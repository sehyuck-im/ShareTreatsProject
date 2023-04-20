package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;


import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;

import java.util.List;

public interface ExchangeService {

    List<GoodsCode> readyGoodsCodes(int quantity);

    String checkValidation(String targetCode, List<GoodsCode> goodsCodeList);

    int selectGoodsCodeIndex(GoodsCode temp, List<GoodsCode> goodsCodeList);

    boolean isValidGoodsCode(String targetCode, List<GoodsCode> goodsCodeList);

    List<GoodsCode> markAsUsed(String targetCode, String storeCode, List<GoodsCode> goodsCodeList);

    boolean isStoreCode(String storeCode);
}
