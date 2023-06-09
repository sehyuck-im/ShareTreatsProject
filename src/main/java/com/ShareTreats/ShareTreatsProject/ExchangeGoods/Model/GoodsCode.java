package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import lombok.Data;

import java.util.Objects;


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
    public GoodsCode(String code) {
        this.code = code;
        this.isExchanged = false;
        this.exchangedStore = new Store("none");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsCode goodsCode = (GoodsCode) o;
        return Objects.equals(code, goodsCode.code);
    }
    public boolean equals(String str) {
        GoodsCode goodsCode = new GoodsCode();
        goodsCode.setCode(str);
        return Objects.equals(code, goodsCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
