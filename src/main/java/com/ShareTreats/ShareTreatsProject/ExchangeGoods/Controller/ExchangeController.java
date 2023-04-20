package com.ShareTreats.ShareTreatsProject.ExchangeGoods.Controller;

import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Model.GoodsCode;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.ExchangeService;
import com.ShareTreats.ShareTreatsProject.ExchangeGoods.Service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


@Controller
@RequestMapping("/exchangeGoods")
public class ExchangeController {

    ExchangeService exchangeService;
    InfoService infoService;

    List<GoodsCode> goodsCodeList = new ArrayList<>(); // 상품코드를 담은 리스트

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean exit = false;

    }
}
