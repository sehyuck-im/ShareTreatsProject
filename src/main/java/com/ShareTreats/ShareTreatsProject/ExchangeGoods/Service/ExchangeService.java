package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;


import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;

import java.util.List;

public interface ExchangeService {

    boolean isValidGoodsCode(String targetCode, List<GoodsCode> goodsCodeList);

    List<GoodsCode> readyGoodsCodes(int quantity);

    String checkValidation(String targetCode, List<GoodsCode> goodsCodeList);

    GoodsCode selectGoodsCode(GoodsCode temp, List<GoodsCode> goodsCodeList);

}
