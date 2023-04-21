package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Customer;

public interface PickUpGoodsService {

    Customer topUpBalance(Customer customer, int topUpCount);

    boolean checkBalance(int drawCount, Customer customer);
}
