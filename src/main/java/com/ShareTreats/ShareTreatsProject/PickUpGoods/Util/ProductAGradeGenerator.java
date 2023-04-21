package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;

import java.time.LocalDateTime;
import java.util.Random;

public class ProductAGradeGenerator {

    private static final String[] PRODUCT_NAMES = {"CIDER", "COLA", "BUBBLE GUM", "CANDY", "SNACK"};
    private static final String PRODUCT_GRADES = "A";
    private static final Random random = new Random();

    public static Product generateProduct() {
        String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
        return new Product(productName, PRODUCT_GRADES);
    }

}
