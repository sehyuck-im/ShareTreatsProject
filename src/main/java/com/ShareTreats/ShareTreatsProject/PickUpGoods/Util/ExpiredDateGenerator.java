package com.ShareTreats.ShareTreatsProject.PickUpGoods.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class ExpiredDateGenerator {
    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final Random RANDOM = new Random();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LocalDateTime generateExpiredDate() {
        LocalDateTime expiredDateTime = NOW.minusMinutes(RANDOM.nextInt(60 * 24 * 365));
        return LocalDateTime.parse(expiredDateTime.format(FORMATTER), FORMATTER);
    }
}
