package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Controller;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.ExchangeService;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;


@Controller
@RequestMapping("/exchangeGoods")
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final InfoService infoService;
    private List<GoodsCode> goodsCodeList;

    public ExchangeController(ExchangeService exchangeService, InfoService infoService) {
        this.exchangeService = exchangeService;
        this.infoService = infoService;
        this.goodsCodeList = exchangeService.readyGoodsCodes(20);
    }

    public void run() {
        infoService.showData(goodsCodeList);
        infoService.showCommand();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;

        while (!exit) {
            try {
                String input = br.readLine();
                if (input.length() > 30) {
                    infoService.overflowInput();
                    continue;
                }

                StringTokenizer st = new StringTokenizer(input, " ");

                String command = st.hasMoreTokens() ? st.nextToken() : "";
                switch (command) {
                    case "EXIT":
                        infoService.exit();
                        exit = true;
                        break;

                    case "CHECK":
                        handleCheckCommand(st);
                        break;

                    case "CLAIM":
                        handleClaimCommand(st);
                        break;

                    case "HELP":
                        infoService.showHelp();
                        break;

                    default:
                        System.out.println("사용법을 확인해주세요");
                        infoService.showCommand();
                }

            } catch (IOException e) {
                infoService.inputErr();
            }
        }
    }

    private void handleCheckCommand(StringTokenizer st) {
        if (st.countTokens() == 1) {
            String targetCode = st.nextToken();
            System.out.println(exchangeService.checkValidation(targetCode, goodsCodeList));
        } else {
            System.out.println(infoService.invalidCheckCode(st));
        }
    }

    private void handleClaimCommand(StringTokenizer st) {
        if (st.countTokens() == 2) {
            String storeCode = st.nextToken();
            if (exchangeService.isStoreCode(storeCode)) {
                String targetCode = st.nextToken();
                goodsCodeList = exchangeService.markAsUsed(targetCode, storeCode, goodsCodeList);
            } else {
                System.out.println(infoService.invalidStoreCode(storeCode));
            }
        } else {
            infoService.wrongInputForClaim(st);
        }
    }
}




