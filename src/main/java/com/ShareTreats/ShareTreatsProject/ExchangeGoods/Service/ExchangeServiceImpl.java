package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService{


    @Override
    public List<GoodsCode> ready10GoodsCodes() {
        List<GoodsCode> goodsCodeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GoodsCode goodsCode = new GoodsCode();
            if(goodsCodeList.contains(goodsCode)){ // goodsCode code로 중복 체크
                String code = GoodsCodeGenerator.generateCode();
                while(goodsCodeList.contains(code)){ // 중복이 안되는게 나올때 까지
                    code = GoodsCodeGenerator.generateCode();
                }
                goodsCode.setCode(code);
            }
            goodsCodeList.add(goodsCode);
        }

        return goodsCodeList;
    }
}
