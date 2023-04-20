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

    List<GoodsCode> goodsCodeList;



    @Test
    void markAsUsed(){ //코드 사용 처리 메소드
        // 존재하는 코드면 사용처리가 되었는지 확인, 사용처리 할 수 있으면 사용 처리, 이미 사용된거면 사용불가 안내
        // String markAsUsed(String targetCode, List<GoodsCode> goodsCodeList);
        prepareMockData();
        // 0,1 은 존재하는 code, [2]는 없는 코드
        String[] testInputs = {goodsCodeList.get(0).getCode(), goodsCodeList.get(1).getCode(), "asdfasfd"};
        for(int i=0; i< testInputs.length; i++){
            GoodsCode temp = new GoodsCode();
            temp.setCode(testInputs[i]);
            if(exchangeService.isValidGoodsCode(testInputs[i], goodsCodeList)){
                GoodsCode targetGoodsCode = exchangeService.selectGoodsCode(temp, goodsCodeList);
                if(targetGoodsCode.isExchanged()){// 사용된 코드
                    System.out.println("이미 사용된 코드입니다.");
                }else{
                    targetGoodsCode.setExchanged(true);
                    targetGoodsCode.setExchangedStore(new Store(StoreCodeGenerator.generateCode()));

                }

            }else{
                System.out.println("사용할 수 없는 코드 입니다.");
            }
        }
    }

    @Test
    void selectGoodsCodeIndex(){ //code를 key로 list에서 객체 가져오기
        // GoodsCode selectGoodsCode(GoodsCode temp, List<GoodsCode> goodsCodeList)
        prepareMockData();
        String testInput = goodsCodeList.get(0).getCode();
        GoodsCode temp = new GoodsCode();
        temp.setCode(testInput);
        System.out.println("temp = " + temp);

        int index = goodsCodeList.indexOf(temp);
        temp = goodsCodeList.get(index);
        System.out.println("temp = " + temp);

    }

    @Test
    void isValidGoodsCode(){ // code가 존재하는지 확인하는 메소드
        // boolean isValidGoodsCode(String targetCode, List<GoodsCode> goodsCodeList);
        prepareMockData();
        // 0,1 은 존재하는 code, [2]는 없는 코드
        String[] testInputs = {goodsCodeList.get(0).getCode(), goodsCodeList.get(1).getCode(), "asdfasfd"};
        for(int i=0; i< testInputs.length; i++){
            GoodsCode temp = new GoodsCode();
            temp.setCode(testInputs[i]);
            System.out.println("goodsCodeList.contains(temp) = " + goodsCodeList.contains(temp));

        }
    }

    @Test
    void prepareMockData(){
        // given 상품 코드 10개가 주어지며 5개는 이미 사용한 코드
        goodsCodeList = exchangeService.readyGoodsCodes(10);
        // index 0, 1을 mock data로 사용할 예정
        System.out.println("goodsCodeList.get(0).getCode() = " + goodsCodeList.get(0).getCode());
        System.out.println("goodsCodeList.get(0).isExchanged() = " + goodsCodeList.get(0).isExchanged());
        System.out.println("goodsCodeList.get(0).getExchangedStore().getStoreCode() = " + goodsCodeList.get(0).getExchangedStore().getStoreCode());

        System.out.println("goodsCodeList.get(1).getCode() = " + goodsCodeList.get(1).getCode());
        System.out.println("goodsCodeList.get(1).isExchanged() = " + goodsCodeList.get(1).isExchanged());
        System.out.println("goodsCodeList.get(1).getExchangedStore().getStoreCode() = " + goodsCodeList.get(1).getExchangedStore().getStoreCode());
    }

    @Test
    void checkValidation(){
        // 고객은 상품 코드를 사용하기 전에 미리 상품을 교환할 수 있는지 확인이 가능합니다.

        prepareMockData();
        // 0,1 은 존재하는 code, [2]는 없는 코드
        String[] testInputs = {goodsCodeList.get(0).getCode(), goodsCodeList.get(1).getCode(), "asdfasfd"};

        // service 호출 영역
        // String checkValidation(String targetCode, List<GoodsCode> goodsCodeList);
        for(int i=0; i< testInputs.length; i++){

            String output = exchangeService.checkValidation(testInputs[i], goodsCodeList);
            System.out.println(output);
//            GoodsCode temp = new GoodsCode();
//            temp.setCode(testInputs[i]);
//            if(goodsCodeList.contains(temp)){
//                int index = goodsCodeList.indexOf(temp);
//                GoodsCode targetGoodsCode = goodsCodeList.get(index);
//                System.out.println("testInput["+i+"] 은 존재하는 데이터");
//                System.out.println("targetGoodsCode.getCode() = " + targetGoodsCode.getCode());
//                System.out.println("targetGoodsCode.isExchanged() = " + targetGoodsCode.isExchanged());
//                System.out.println("targetGoodsCode.getExchangedStore().getStoreCode() = " + targetGoodsCode.getExchangedStore().getStoreCode());
//
//            }else{
//                System.out.println("testInput["+i+"] 은 잘못된 코드 입니다.");
//            }
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