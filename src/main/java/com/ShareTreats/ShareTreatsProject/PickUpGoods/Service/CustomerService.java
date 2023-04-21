package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Customer;

public interface CustomerService{

    Customer topUpBalance(Customer customer, int topUpCount);

    boolean checkBalance(int drawCount, Customer customer);
}
