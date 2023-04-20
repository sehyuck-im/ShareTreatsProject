package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.StringTokenizer;

import static org.junit.Assert.*;

@SpringBootTest
public class InfoServiceImplTest {
    @Test
    public void showCheckCommand() {
        String testString = "123 12";
        StringTokenizer st = new StringTokenizer(testString, " ");
        StringBuilder sb = new StringBuilder();
        if(st.hasMoreTokens()){
            sb.append("상품코드가 잘못 입력되었습니다.").append("\n");
            sb.append("입력한 코드 : ");
            while(st.hasMoreTokens()){
                sb.append(st.nextToken()).append(" ");
            }
            sb.append("\n");

        }else{
            sb.append("상품코드가 입력되지 않았습니다");
        }
        sb.append("입력 양식에 맞추어 다시 입력해주세요").append("\n");
        sb.append("사용 여부 확인 : CHECK [상품코드]").append("\n");
        sb.append("입력시 예시에있는 [ ]대괄호는 제외하고 입력해주세요.").append("\n");
        sb.append("상품코드 입력시 공백(스페이스바) 제외하고 입력해주세요").append("\n");
        sb.append("상품코드는 0~9 자연수 9자리입니다.").append("\n");
        System.out.println(sb);
    }
}