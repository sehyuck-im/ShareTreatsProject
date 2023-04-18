package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils;

import org.junit.Test;

import java.util.Random;

public class GoodsCodeGenerator {
    private static final int CODE_LENGTH = 9;
    private static final Random RANDOM = new Random();

    public static String generateCode(){
        // 1. 상품 코드는 0~9 자연수 글자로 이루어져 있으며 9문자로 이루어져 있습니다.
        //      -> Random()을 사용해서 9자리 생성
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }


}
