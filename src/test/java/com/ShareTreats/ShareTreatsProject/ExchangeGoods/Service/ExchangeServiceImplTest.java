package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.Store;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.StoreCodeGenerator;
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
class ExchangeServiceImplTest {
    @Autowired
    ExchangeService exchangeService;


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

    @Test
    void readyGoodsCodes() { //상품 코드는 10개가 준비되면 고객에게 10개까지만 제공됩니다.

        List<GoodsCode> goodsCodeList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            GoodsCode goodsCode = new GoodsCode();
            if(goodsCodeList.contains(goodsCode)){
                String code = GoodsCodeGenerator.generateCode();
                while(goodsCodeList.contains(code)){
                    code = GoodsCodeGenerator.generateCode();
                }
                goodsCode.setCode(code);
            }
            if(i%2 == 0){ // 짝수번은 사용처리된 것으로 설정
                String storeCode = StoreCodeGenerator.generateCode();
                Store store = new Store(storeCode);
                goodsCode.setExchanged(true);
                goodsCode.setExchangedStore(store);
            }
            goodsCodeList.add(goodsCode);
        }
        System.out.println("goodsCodeList = " + goodsCodeList);
    }

    @Test
    void generateGoodsCode() {
        String code = GoodsCodeGenerator.generateCode();
        System.out.println("code = " + code);
    }

    @Test
    void generateStoreCode(){
        String code = StoreCodeGenerator.generateCode();
        System.out.println("code = " + code);
    }


}