package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Override
    public void showCommand() {
        StringBuilder sb = new StringBuilder();

        sb.append("입력 양식").append("\n");
        sb.append("사용 여부 확인 : CHECK [상품코드]").append("\n");
        sb.append("도움말 : HELP").append("\n");
        sb.append("사용 처리 : CLAIM [상점코드] [상품코드]").append("\n");
        sb.append("프로그램 종료 : EXIT").append("\n");

        System.out.println(sb);
    }

    @Override
    public void showHelp() {
        StringBuilder sb = new StringBuilder();

        sb.append("도움말").append("\n");
        sb.append("사용 여부 확인 : CHECK [상품코드]").append("\n");
        sb.append("사용 처리 : CLAIM [상점코드] [상품코드]").append("\n");
        sb.append("CHECK, CLAIM은 영문대문자로 입력하셔야합니다.").append("\n");
        sb.append("입력시 예시에있는 [ ]대괄호는 제외하고 입력해주세요.").append("\n");
        sb.append("상점코드, 상품코드 입력시 공백(스페이스바) 제외하고 입력해주세요").append("\n");
        sb.append("상점코드는 영문대소문자 6자리, 상품코드는 0~9 자연수 9자리입니다.").append("\n");
        sb.append("프로그램 종료 : EXIT").append("\n");

        System.out.println(sb);
    }

    @Override
    public void showData(List<GoodsCode> goodsCodeList) {
        StringBuilder sb = new StringBuilder();

        sb.append(goodsCodeList.size()+"개의 데이터").append("\n");
        for(int i=0; i<goodsCodeList.size(); i++){
            GoodsCode temp = goodsCodeList.get(i);
            sb.append("코드 : "+temp.getCode()+", 사용 여부 : "+temp.isExchanged()+", 사용처 : "+temp.getExchangedStore().getStoreCode()).append("\n");
        }
        System.out.println(sb);
    }


}
