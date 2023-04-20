package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;

import java.util.List;
import java.util.StringTokenizer;

public interface InfoService {

    void showCommand();

    void showHelp();

    void showData(List<GoodsCode> goodsCodeList);

    void inputErr();

    void exit();

    String invalidCheckCode(StringTokenizer st);

    String invalidStoreCode(String storeCode);

    void wrongInputForClaim(StringTokenizer st);
}
