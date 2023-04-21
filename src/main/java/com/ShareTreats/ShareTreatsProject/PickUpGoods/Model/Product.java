package com.ShareTreats.ShareTreatsProject.PickUpGoods.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {
    private String name; // 상품 이름
    private String grade; // 상품 등급
    private LocalDateTime expirationDate; // 유통기한

    public Product(String name, String grade, LocalDateTime expirationDate) {
        this.name = name;
        this.grade = grade;
        this.expirationDate = expirationDate;
    }

    public Product(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

}
