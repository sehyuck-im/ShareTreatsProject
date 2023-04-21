package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import java.time.LocalDateTime;
import java.util.Random;

public class ExpiredDateGenerator {
    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final Random RANDOM = new Random();

    public LocalDateTime generateExpirationDate(){

        return NOW.plusHours(RANDOM.nextInt(24 * 365));
    }

}
