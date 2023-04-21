package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Customer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class CustomerServiceImplTest {

    private CustomerService pickUpGoodsService = new CustomerServiceImpl();

    Map<String, Customer> customerMap = new HashMap<>();

    @Test
    public void topUpBalance(){
        // 고객 지갑 충전
        // Customer topUpBalance(Customer customer, int topUpCount);
        Customer customer = new Customer();
        customer.setBalance(500);
        System.out.println("customer = " + customer);
        customer = pickUpGoodsService.topUpBalance(customer, 5000);
        System.out.println("customer = " + customer);
//        System.out.println("customer = " + customer);
//        customer.setBalance(9000+customer.getBalance());
//        System.out.println("customer = " + customer);

    }

    @Test
    public void checkBalance(){
        // boolean checkBalance(int drawCount, Customer customer);
        // customer.balance 가 drawCount를 빼도 남는지 확인
        Customer customer = new Customer();
        int drawCount = 1000;
        customer.setBalance(900);
        
        if(customer.getBalance()-drawCount > 0){
            System.out.println("뽑기 가능");
        }else{
            System.out.println("잔액 부족");
        }
    }

}