package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;


import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;

import java.util.List;

public interface ExchangeService {

    List<GoodsCode> readyGoodsCodes(int quantity);


}
