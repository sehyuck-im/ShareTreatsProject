package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeServiceImplTest {

    @Test
    void ready10GoodsCodes() { //상품 코드는 10개가 준비되면 고객에게 10개까지만 제공됩니다.
        List<GoodsCode> goodsCodeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GoodsCode goodsCode = new GoodsCode();
            if(goodsCodeList.contains(goodsCode)){
                String code = GoodsCodeGenerator.generateCode();
                while(goodsCodeList.contains(code)){
                    code = GoodsCodeGenerator.generateCode();
                }
                goodsCode.setCode(code);
            }
            goodsCodeList.add(goodsCode);
        }
        System.out.println("goodsCodeList = " + goodsCodeList);
    }


    @Test
    void generateCode() {
        String code = GoodsCodeGenerator.generateCode();
        System.out.println("code = " + code);

    }
}