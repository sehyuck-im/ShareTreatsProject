package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ProductAGradeGeneratorTest {

    private ProductAGradeGenerator productAGradeGenerator = new ProductAGradeGenerator();
    private ProductBGradeGenerator productBGradeGenerator = new ProductBGradeGenerator();

    @Test
    public void generatorTestB(){
        Product product = productBGradeGenerator.generateProduct();
        System.out.println(product);
    }

    @Test
    public void generatorTest(){
        Product product = productAGradeGenerator.generateProduct();
        System.out.println(product);
    }
}