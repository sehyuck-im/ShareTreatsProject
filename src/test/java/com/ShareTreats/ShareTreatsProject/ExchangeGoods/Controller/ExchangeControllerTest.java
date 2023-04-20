package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Controller;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.ExchangeService;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.InfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeControllerTest {
    @Autowired
    ExchangeService exchangeService;
    @Autowired
    InfoService infoService;

    List<GoodsCode> goodsCodeList;

    @Test
    void mockTest() { // 사용자의 입력을 받아 상품코드 조회, 사용처리
        prepareMockData();
        infoService.showData(goodsCodeList);
        infoService.showCommand();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean exit = false;
        while (!exit) {
            try {
                String input = br.readLine();
                if(input.length()>30){
                    infoService.overflowInput();
                }
                st = new StringTokenizer(input, " ");
                // final int INPUT_MAX_LENGTH = 30;

                // command 확인

                String command = st.hasMoreTokens() ? st.nextToken() : "";
                if (command.equals("EXIT")) { // 종료
                    infoService.exit();
                    exit = true;
                } else if (command.equals("CHECK")) { // 상품코드 조회

                    if (st.countTokens() == 1) { // 상품코드가 입력된 경우
                        String targetCode = st.nextToken();
                        // 리스트에 코드가 포함되어있으면 출력, 없으면 없다고 출력
                        System.out.println(exchangeService.checkValidation(targetCode, goodsCodeList));
                    } else { // 상품코드가 입력 안되었거나 잘못 입력한 경우
                        System.out.println(infoService.invalidCheckCode(st));
                    }

                } else if (command.equals("CLAIM")) { // 상품코드 사용

                    if (st.countTokens() == 2) { // 상점코드와 상품코드가 입력된 경우
                        String storeCode = st.nextToken();
                        if (exchangeService.isStoreCode(storeCode)) { // 상점코드가 맞으면
                            String targetCode = st.nextToken();
                            goodsCodeList = exchangeService.markAsUsed(targetCode, storeCode, goodsCodeList);

                        } else { // 유효한 상점코드가 아닌 경우
                            System.out.println(infoService.invalidStoreCode(storeCode));
                        }
                    } else { // 입력을 잘못한 경우
                        infoService.wrongInputForClaim(st);
                    }

                }else if(command.equals("HELP")){
                        infoService.showHelp();
                }else {
                    System.out.println("사용법을 확인해주세요");
                    infoService.showCommand();
                }

            } catch (IOException e) { // 입력 오류가 존재할때
                infoService.inputErr();
            }
        }

    }

    @Test
    void prepareMockData() {
        // given 상품 코드 10개가 주어지며 5개는 이미 사용한 코드
        goodsCodeList = exchangeService.readyGoodsCodes(10);

    }


}