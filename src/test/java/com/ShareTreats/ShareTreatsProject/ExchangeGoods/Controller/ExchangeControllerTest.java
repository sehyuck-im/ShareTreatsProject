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
    /*
        1. 문자열은 0~9, a~z, A~Z, SPACE 까지의 문자를 무작위로 입력할 수 있습니다.
        2. 문자열의 길이는 최대 30글자까지 입력할 것입니다.
            - 고객에게 원하는 입력 형식
            CHECK [상품코드]
            HELP
            CLAIM [상점코드] [상품코드]

            - 고객의 입력 예시
            Check 132 421 122
            HELP
            claIm ABcde 1231 2312 123
     */

    @Test
    void mockTest() { // 사용자의 입력을 받아 상품코드 조회, 사용처리
        prepareMockData();
        infoService.showData(goodsCodeList);
        infoService.showCommand();
        infoService.showHelp();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean exit = false;
        while (!exit) {
            try {
                st = new StringTokenizer(br.readLine(), " ");
                // command 확인
                String command = st.nextToken();
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
                    System.out.println("사용합니다");
                } else {
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