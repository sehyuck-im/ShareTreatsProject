package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ExpiredDateGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductAGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ProductBGradeGenerator;
import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ValidExpirationDateGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    private ProductService productService = new ProductServiceImpl();
    private ProductAGradeGenerator productAGradeGenerator = new ProductAGradeGenerator();
    private ProductBGradeGenerator productBGradeGenerator = new ProductBGradeGenerator();
    private ValidExpirationDateGenerator validExpirationDateGenerator = new ValidExpirationDateGenerator();
    private ExpiredDateGenerator expiredDateGenerator = new ExpiredDateGenerator();

    Map<Integer, Product> productMapA = new HashMap<>();
    Map<Integer, Product> productMapB = new HashMap<>();

    @Test
    public void pickA(){
        int count = 5; // 상품 index 수
        productMapA = productService.productMapA(count);
        // A에 당첨되어 A 상품 선택
        Random random = new Random();
        int productIndex = random.nextInt(count);
        System.out.println("productIndex = " + productIndex);
        Product product = productMapA.get(productIndex);
        System.out.println("product = " + product);


    }

    @Test
    public void isValidProduct(){
        // 유통기한이 지났느지 않지났는지 확인
        // boolean isValidProduct(Product product)
        readyProductMapB();
        for(int i=0; i<2; i++){
            Product product = productMapB.get(i);
            System.out.println("productService.isValidProduct(product) = " + productService.isValidProduct(product));
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println("product.getExpirationDate() = " + product.getExpirationDate());
//            System.out.println("now = " + now);
//            int result = product.getExpirationDate().compareTo(now);
//            System.out.println("result = " + result);
//            if(result > 0){
//                System.out.println("사용가능");
//            }else{
//                System.out.println("사용불가");
//            }
        }

    }

    @Test
    public void readyProductMapB(){
        productMapB = productService.productMapB(5);
        System.out.println("productMapB = " + productMapB);
//        int count = 5;
//        for(int i=0; i<count; i++){ // 홀수 index expired 상품
//            Product product = productBGradeGenerator.generateProduct();
//            if(i%2==0){
//                product.setExpirationDate(validExpirationDateGenerator.generateValidExpirationDate());
//            }else{
//                product.setExpirationDate(expiredDateGenerator.generateExpiredDate());
//            }
//            productMapB.put(i, product);
//        }
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
        productMapA = new HashMap<>();
        int count = 5;
        for(int i=0; i<count; i++){ // 홀수 index expired 상품
            Product product = productAGradeGenerator.generateProduct();
            if(i%2==0){
                product.setExpirationDate(validExpirationDateGenerator.generateValidExpirationDate());
            }else{
                product.setExpirationDate(expiredDateGenerator.generateExpiredDate());
            }
            productMapA.put(i, product);
        }
        System.out.println("productMap = " + productMapA);
    }
}