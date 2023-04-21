package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ProductAGradeGeneratorTest {

    private ProductAGradeGenerator productAGradeGenerator = new ProductAGradeGenerator();
    @Test
    public void generatorTest(){
        Product product = productAGradeGenerator.generateProduct();
        System.out.println(product);
    }
}