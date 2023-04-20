package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;

import java.util.List;

public interface InfoService {

    void showCommand();

    void showHelp();

    void showData(List<GoodsCode> goodsCodeList);
}
