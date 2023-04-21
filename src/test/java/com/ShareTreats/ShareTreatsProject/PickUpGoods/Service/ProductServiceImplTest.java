package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ExpiredDateGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductAGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductBGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ValidExpirationDateGenerator;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ProductServiceImplTest {

    private CustomerService pickUpGoodsService = new CustomerServiceImpl();
    private ProductAGradeGenerator productAGradeGenerator = new ProductAGradeGenerator();
    private ProductBGradeGenerator productBGradeGenerator = new ProductBGradeGenerator();
    private ValidExpirationDateGenerator validExpirationDateGenerator = new ValidExpirationDateGenerator();
    private ExpiredDateGenerator expiredDateGenerator = new ExpiredDateGenerator();

    @Test
    public void isValidProduct(){
        // 유통기한이 지났느지 않지났는지 확인
        // boolean isValidProduct(Product product)


    }

    @Test
    public void readyProductMapB(){
        Map<Integer, Product> productMap = new HashMap<>();
        int count = 5;
        for(int i=0; i<5; i++){ // 홀수 index expired 상품
            Product product = productBGradeGenerator.generateProduct();
            if(i%2==0){
                product.setExpirationDate(validExpirationDateGenerator.generateValidExpirationDate());
            }else{
                product.setExpirationDate(expiredDateGenerator.generateExpiredDate());
            }
            productMap.put(i, product);
        }
        System.out.println("productMap = " + productMap);
    }

    @Test
    public void readyProductMapA(){
        // 상품은 총 10 종류를 개발자가 임의로 제공합니다. // A 등급 5개 B등급 5개
//        상품종류의 표현은 다음과 같습니다.
//        [상품종류],[등급],[유통기한]
//        예시)
//        CHICKEN, B, 2023-03-23T02:20:19+09:00
//        CIDER, A, 2021-02-10T02:28:56+09:00
//        COLA, A, 2021-03-21T01:00:32+09:00
        Map<Integer, Product> productMap = new HashMap<>();
        for(int i=0; i<5; i++){ // 홀수 index expired 상품
            Product product = productAGradeGenerator.generateProduct();
            if(i%2==0){
                product.setExpirationDate(validExpirationDateGenerator.generateValidExpirationDate());
            }else{
                product.setExpirationDate(expiredDateGenerator.generateExpiredDate());
            }
            productMap.put(i, product);
        }
        System.out.println("productMap = " + productMap);
    }
}