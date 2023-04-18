package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeServiceImplTest {

    @Test
    void ready10GoodsCodes(){ //상품 코드는 10개가 준비되면 고객에게 10개까지만 제공됩니다.

        List<GoodsCode> goodsCodeList = new ArrayList<>();
        for(int i=0; i<10; i++){
            GoodsCode goodsCode = new GoodsCode();

            System.out.println(i+"번 째");
        }
    }

    private static final int CODE_LENGTH = 9;
    private static final Random RANDOM = new Random();

    @Test
    String generateCode(){
        // 1. 상품 코드는 0~9 자연수 글자로 이루어져 있으며 9문자로 이루어져 있습니다.
        //      -> Random()을 사용해서 9자리 생성
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        System.out.println("sb = " + sb);
        return sb.toString();
    }
}