package com.ShareTreats.ShareTreatsProject.PickUpGoods.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private int balance; // 고객 잔액
    private int drawCount; // 뽑기 횟수
    private LocalDateTime lastDrawTime; // 마지막 뽑기 시간

    public Customer(int balance, int drawCount, LocalDateTime lastDrawTime) {
        this.balance = balance;
        this.drawCount = drawCount;
        this.lastDrawTime = lastDrawTime;
    }

    public Customer() {
        this.balance = 10000;
        this.drawCount = 0;
        this.lastDrawTime = LocalDateTime.now();
    }
}
