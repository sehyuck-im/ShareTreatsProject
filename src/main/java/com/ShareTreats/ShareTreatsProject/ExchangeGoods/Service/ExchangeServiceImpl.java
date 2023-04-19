package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.Store;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.GoodsCodeGenerator;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Utils.StoreCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService{


    @Override
    public List<GoodsCode> readyGoodsCodes(int quantity) { // quantity 가 들어오는 만큼 테스트 데이터 생성

        List<GoodsCode> goodsCodeList = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            GoodsCode goodsCode = new GoodsCode();
            if(goodsCodeList.contains(goodsCode)){ // goodsCode code로 중복 체크
                String code = GoodsCodeGenerator.generateCode();
                while(goodsCodeList.contains(code)){ // 중복이 안되는게 나올때 까지
                    code = GoodsCodeGenerator.generateCode();
                }
                goodsCode.setCode(code);
            }
            if(i%2 == 0){ // 짝수번은 사용처리된 것으로 설정
                String storeCode = StoreCodeGenerator.generateCode();
                Store store = new Store(storeCode);
                goodsCode.setExchanged(true);
                goodsCode.setExchangedStore(store);
            }
            goodsCodeList.add(goodsCode);
        }

        return goodsCodeList;
    }
}
