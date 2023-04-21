package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class ValidExpirationDateGenerator {
    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final Random RANDOM = new Random();


    public LocalDateTime generateExpirationDate(){

        return NOW.plusHours(RANDOM.nextInt(24 * 365))
                .withNano(0)
                .withSecond(0);
    }

}
