package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer topUpBalance(Customer customer, int topUpCount) {
        customer.setBalance(customer.getBalance()+topUpCount);

        return customer;
    }

    @Override
    public boolean checkBalance(int drawCount, Customer customer) {
        return customer.getBalance()-drawCount>0?true:false;
    }
}
