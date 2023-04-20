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
        for (int i = 0; i < quantity; i++) {
            GoodsCode goodsCode = new GoodsCode();
            if(goodsCodeList.contains(goodsCode)){ // goodsCode code로 중복 체크
                String code = GoodsCodeGenerator.generateCode();
                while(goodsCodeList.contains(code)){ // 중복이 안되는게 나올때 까지
                    code = GoodsCodeGenerator.generateCode();
                }
                goodsCode.setCode(code);
            }
            if(i%2 == 0){ // 홀수번은 사용처리된 것으로 설정
                String storeCode = StoreCodeGenerator.generateCode();
                Store store = new Store(storeCode);
                goodsCode.setExchanged(true);
                goodsCode.setExchangedStore(store);
            }
            goodsCodeList.add(goodsCode);
        }

        return goodsCodeList;
    }

    @Override
    public boolean isValidGoodsCode(String targetCode, List<GoodsCode> goodsCodeList) {

        return goodsCodeList.contains(new GoodsCode(targetCode));
    }

    @Override
    public List<GoodsCode> markAsUsed(String targetCode, List<GoodsCode> goodsCodeList) {
        StringBuilder sb = new StringBuilder();
        if(isValidGoodsCode(targetCode, goodsCodeList)){
            GoodsCode temp = new GoodsCode();
            temp.setCode(targetCode);
            int index = selectGoodsCodeIndex(temp, goodsCodeList);
            if(goodsCodeList.get(index).isExchanged()){// 사용된 코드
                sb.append("사용 실패").append("\n");
                sb.append("해당 "+targetCode+"는 이미 "+goodsCodeList.get(index).getExchangedStore().getStoreCode()+"에서 사용된 코드입니다.");
            }else{
                goodsCodeList.get(index).setExchanged(true);
                String storeCode = StoreCodeGenerator.generateCode();
                goodsCodeList.get(index).setExchangedStore(new Store(storeCode));
                sb.append("사용 성공").append("\n");
                sb.append(targetCode+"를 "+storeCode+"에서 사용 완료되었습니다.");
            }
            System.out.println(sb);
        }else{
            System.out.println("사용할 수 없는 코드 입니다.");
        }

        return goodsCodeList;
    }

    @Override
    public String checkValidation(String targetCode, List<GoodsCode> goodsCodeList){
        GoodsCode temp = new GoodsCode();
        temp.setCode(targetCode);
        StringBuilder sb = new StringBuilder();
        if(isValidGoodsCode(targetCode, goodsCodeList)){ // list에 targetCode를 가진 객체가 존재할 경우
            int index = goodsCodeList.indexOf(temp);
            GoodsCode targetGoodsCode = goodsCodeList.get(index);
            sb.append("확인 요청하신 "+targetGoodsCode.getCode()+"는 ");
            if(targetGoodsCode.isExchanged()){ // 사용된 코드
                sb.append("사용된 코드이며 사용된 상점은 "+targetGoodsCode.getExchangedStore().getStoreCode()+"입니다");
            }else{ // 사용할 수 있는 코드
                sb.append("사용하실 수 있는 코드입니다.");
            }

        }else{ // 해당하는 객체가 없는 경우
            sb.append("존재하지 않는 코드입니다.");
        }
        return sb.toString();
    }

    @Override
    public int selectGoodsCodeIndex(GoodsCode temp, List<GoodsCode> goodsCodeList) {
        return goodsCodeList.indexOf(temp);
    }
}
