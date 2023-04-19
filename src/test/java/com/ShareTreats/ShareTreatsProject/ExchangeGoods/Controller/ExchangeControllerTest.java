package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Controller;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.ExchangeService;
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
    void checkValidation() {
        // 고객은 상품 코드를 사용하기 전에 미리 상품을 교환할 수 있는지 확인이 가능합니다.
        // given 상품 코드 10개가 주어지며 5개는 이미 사용한 코드
        List<GoodsCode> goodsCodeList = exchangeService.readyGoodsCodes(10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        boolean exit = false;
        while(!exit){
            sb.setLength(0); // StringBuilder 객체의 내용을 지웁니다.
            sb.append("list 길이 = "+goodsCodeList.size()+"\n");
            for(int i=0; i<goodsCodeList.size(); i++){
                GoodsCode temp = goodsCodeList.get(i);
                sb.append((i+1)+"번째 code = "+temp.getCode()+", 사용 여부 = "+temp.isExchanged()+" 사용처 = "+temp.getExchangedStore().getStoreCode()).append("\n");
            }
            sb.append("확인할 코드를 입력해 주세요."+"\n");
            sb.append("입력 예시").append("\n");
            sb.append("CHECK [상품코드]  (상품코드 입력시 [] 제외, 공백(스페이스) 없이 입력해주세요");
            System.out.println(sb);
            try {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                if(command.equals("EXIT")){
                    exit = true;
                }

                if(command.equals("CHECK") && st.hasMoreTokens()){
                    String checkCode = st.nextToken();
                    if(checkCode.length() != 9){
                        System.out.println("존재하지 않거나 상품코드를 잘못 입력하셨습니다. 확인 후 다시 입력 해주세요.");
                    }else if(st.hasMoreTokens()){
                        System.out.println("확인 요청이 잘못되었습니다. 확인 후 다시 입력 해주세요.");
                    }

                    GoodsCode temp = new GoodsCode();
                    temp.setCode(checkCode);
                    if(goodsCodeList.contains(temp)){
                        int index = goodsCodeList.indexOf(temp);
                        GoodsCode targetGoodsCode = goodsCodeList.get(index);
                        sb.append("요청하신 코드 "+targetGoodsCode.getCode());
                        if(targetGoodsCode.isExchanged()){
                            sb.append("는 이미 "+targetGoodsCode.getExchangedStore().getStoreCode()+"에서 사용되었습니다"+"\n");
                        }else{
                            sb.append("사용 가능합니다");
                        }
                        System.out.println(sb);
                    }else{
                        System.out.println("존재하지 않거나 상품코드를 잘못 입력하셨습니다. 확인 후 다시 입력 해주세요.");
                    }

                }else{ //에러

                }
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }

}