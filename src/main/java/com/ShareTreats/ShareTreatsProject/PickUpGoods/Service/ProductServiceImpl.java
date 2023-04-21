package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ExpiredDateGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductAGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductBGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ValidExpirationDateGenerator;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl {
    ProductAGradeGenerator productAGradeGenerator;
    ProductBGradeGenerator productBGradeGenerator;
    ValidExpirationDateGenerator validExpirationDateGenerator;
    ExpiredDateGenerator expiredDateGenerator;

    public Map<Integer, Product> productMapB(int count) {
        return getIntegerProductMap(count, productBGradeGenerator.generateProduct());
    }

    private Map<Integer, Product> getIntegerProductMap(int count, Product product2) {
        Map<Integer, Product> productMap = new HashMap<>();
        for (int i = 0; i < count; i++) { // 홀수 index expired 상품
            Product product = product2;
            if (i % 2 == 0) {
                product.setExpirationDate(validExpirationDateGenerator.generateValidExpirationDate());
            } else {
                product.setExpirationDate(expiredDateGenerator.generateExpiredDate());
            }
            productMap.put(i, product);
        }
        return productMap;
    }

    public Map<Integer, Product> productMapA(int count) {
        return getIntegerProductMap(count, productAGradeGenerator.generateProduct());
    }
}
