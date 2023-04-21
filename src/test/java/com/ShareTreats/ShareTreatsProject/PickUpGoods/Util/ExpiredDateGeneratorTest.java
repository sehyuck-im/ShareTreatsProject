package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ExpiredDateGeneratorTest {

    @Test
    public void generatorTest(){
        ExpiredDateGenerator expiredDateGenerator = new ExpiredDateGenerator();
        System.out.println("expiredDateGenerator.generateExpiredDate() = " + expiredDateGenerator.generateExpiredDate());
    }
}