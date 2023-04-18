package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils;

import java.util.Random;

public class StoreCodeGenerator {
    // 상점 코드는 A~Z,a~z 까지의 대,소 영문자만 사용이 가능하며 6문자로 이루어져 있습니다
    public static String generateCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int n = random.nextInt(52);
            char c = (char) (n < 26 ? 'A' + n : 'a' + n - 26);
            sb.append(c);
        }
        return sb.toString();
    }
}
