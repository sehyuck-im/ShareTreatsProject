package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import lombok.Data;

import java.util.Random;

@Data
public class GoodsCode {
    // 상품 코드는 0~9 자연수 글자로 이루어져 있으며 9문자로 이루어져 있습니다.
    private String code;
    // 상품을 교환 했는지 확인
    private boolean isExchanged;
    // 상품 교환한 상점
    private Store exchangedStore;

    public GoodsCode() {
        this.code = GoodsCodeGenerator.generateCode();
        this.isExchanged = false;
        this.exchangedStore = new Store("none");
    }

}
