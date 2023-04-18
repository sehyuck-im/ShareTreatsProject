package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.Store;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.StoreCodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeServiceImplTest {

    @Test
    void ready20GoodsCodes() { //상품 코드는 10개가 준비되면 고객에게 10개까지만 제공됩니다.
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