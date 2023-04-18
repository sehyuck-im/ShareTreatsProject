package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Controller;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.ExchangeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeControllerTest {
    @Autowired
    ExchangeService exchangeService;

    /*
        1. 문자열은 0~9, a~z, A~Z, SPACE 까지의 문자를 무작위로 입력할 수 있습니다.
        2. 문자열의 길이는 최대 30글자까지 입력할 것입니다.
            - 고객에게 원하는 입력 형식
            CHECK [상품코드]
            HELP
            CLAIM [상점코드] [상품코드]

            - 고객의 입력 예시
            Check 132 421 122
            HELP
            claIm ABcde 1231 2312 123
     */


}