package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DrawServiceImpl implements DrawService{
    @Override
    public boolean drawA() {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1부터 10까지의 랜덤 정수를 생성
        return randomNumber != 1; // 90% 확률로 true 반환
    }

    @Override
    public boolean drawB() {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1부터 10까지의 랜덤 정수를 생성
        return randomNumber == 1; // 10% 확률로 true 반환
    }

}
