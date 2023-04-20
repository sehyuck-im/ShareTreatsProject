package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringTokenizer;

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

    @Override
    public void inputErr() {
        StringBuilder sb = new StringBuilder();
        sb.append("입력 오류가 발생하였습니다. 다시 시도해주세요.");
        System.out.println(sb);

    }

    @Override
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public String invalidCheckCode(StringTokenizer st) {
        StringBuilder sb = new StringBuilder();
        if(st.hasMoreTokens()){
            sb.append("상품코드가 잘못 입력되었습니다.").append("\n");
            sb.append("입력한 코드 : ");
            while(st.hasMoreTokens()){
                sb.append(st.nextToken()).append(" ");
            }
            sb.append("\n");

        }else{
            sb.append("상품코드가 입력되지 않았습니다");
        }
        sb.append("입력 양식에 맞추어 다시 입력해주세요").append("\n");
        sb.append("사용 여부 확인 : CHECK [상품코드]").append("\n");
        sb.append("입력시 예시에있는 [ ]대괄호는 제외하고 입력해주세요.").append("\n");
        sb.append("상품코드 입력시 공백(스페이스바) 제외하고 입력해주세요").append("\n");
        sb.append("상품코드는 0~9 자연수 9자리입니다.").append("\n");

        return sb.toString();
    }

    @Override
    public String invalidStoreCode(String storeCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("입력하신 상점 코드 "+storeCode+"는 유효한 상점 코드가 아닙니다.").append("\n");
        sb.append("사용 처리 : CLAIM [상점코드] [상품코드]").append("\n");
        sb.append("입력시 예시에있는 [ ]대괄호는 제외하고 입력해주세요.").append("\n");
        sb.append("상점코드 입력시 공백(스페이스바) 제외하고 입력해주세요").append("\n");
        sb.append("상점코드는 영문대소문자 6자리입니다.").append("\n");

        return sb.toString();
    }

    @Override
    public void wrongInputForClaim(StringTokenizer st) {
        StringBuilder sb = new StringBuilder();
        sb.append("사용 처리 입력이 잘못되었습니다.").append("\n");
        sb.append("입력하신 내용 : CLAIM ");
        if(st.hasMoreTokens()){
            while(st.hasMoreTokens()){
                sb.append(st.nextToken()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        showCommand();
    }

    @Override
    public void overflowInput() {
        System.out.println("30글자 이상 입력하셨습니다. 입력은 30글자 이하로 부탁드립니다.");
    }


}
