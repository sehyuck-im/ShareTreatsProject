package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ValidExpirationDateGeneratorTest {


    @Test
    public void generatorTest(){
        ValidExpirationDateGenerator validExpirationDateGenerator = new ValidExpirationDateGenerator();
        System.out.println("validExpirationDateGenerator.generateValidExpirationDate() = " + validExpirationDateGenerator.generateValidExpirationDate());
    }
}