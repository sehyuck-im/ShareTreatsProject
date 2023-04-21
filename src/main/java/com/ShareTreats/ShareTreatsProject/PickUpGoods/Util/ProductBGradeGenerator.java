package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;

import java.util.Random;

public class ProductBGradeGenerator {

    private static final String[] PRODUCT_NAMES = {"CHICKEN", "PIZZA", "HAMBURGER", "FISH AND CHIPS", "SUSHI"};
    private static final String PRODUCT_GRADES = "B";
    private static final Random random = new Random();

    public static Product generateProduct() {
        String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
        return new Product(productName, PRODUCT_GRADES);
    }

}
