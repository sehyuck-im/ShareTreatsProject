package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Util.ValidExpirationDateGenerator;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PickUpGoodsServiceImplTest {

    @MockBean
    ValidExpirationDateGenerator validExpirationDateGenerator;

    @Test
    public void validExpirationDateGeneratorTest() {
        System.out.println("validExpirationDateGenerator.generateExpirationDate() = " + validExpirationDateGenerator.generateExpirationDate());
    }
}