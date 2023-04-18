package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model;

import lombok.Data;

@Data
public class Store {
    // 상점 코드는 A~Z,a~z 까지의 대,소 영문자만 사용이 가능하며 6문자로 이루어져 있습니다.
    private String storeCode;

    public Store(String storeCode) {
        this.storeCode = storeCode;
    }
}
