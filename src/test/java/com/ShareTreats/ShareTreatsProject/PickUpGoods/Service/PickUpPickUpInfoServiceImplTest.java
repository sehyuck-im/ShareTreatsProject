package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.StringTokenizer;

@SpringBootTest
public class PickUpPickUpInfoServiceImplTest {

    @Test
    public void opening(){
        StringBuilder sb = new StringBuilder();
        sb.append("****************************").append("\n");
        sb.append("ShareTreat 뽑기 프로그램입니다.").append("\n");
        sb.append("****************************").append("\n");
        System.out.println(sb);
    }

    @Test
    public void showCommand() {
        StringBuilder sb = new StringBuilder();

        sb.append("사용법은 아래와 같습니다.").append("\n");
        sb.append("잔고 확인 : CHECK").append("\n");
        sb.append("충전 : TOPUP [금액]").append("\n");
        sb.append("뽑기 : DRAW [횟수]").append("\n");
        sb.append("내가 뽑은 상품 : LIST").append("\n");
        sb.append("종료 : EXIT").append("\n");
        sb.append("입력예시에서 []은 제외하고 입력해주세요.").append("\n");
        System.out.println(sb);
    }



}