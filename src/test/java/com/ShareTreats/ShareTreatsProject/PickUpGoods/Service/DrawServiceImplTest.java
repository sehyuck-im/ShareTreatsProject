package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.Assert.*;

@SpringBootTest
public class DrawServiceImplTest {

    private DrawService drawService = new DrawServiceImpl();


    @Test
    public void drawB(){
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1부터 10까지의 랜덤 정수를 생성
        System.out.println("randomNumber = " + randomNumber);
        System.out.println("(randomNumber == 1) = " + (randomNumber == 1));
    }

    @Test
    public void drawA(){ // 90%로 성공
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1부터 10까지의 랜덤 정수를 생성
        System.out.println("randomNumber = " + randomNumber);
        System.out.println("randomNumber != 1 = " + (randomNumber != 1));
    }

}