package com.ShareTreats.ShareTreatsProject.PickUpGoods.Service;

import com.ShareTreats.ShareTreatsProject.PickUpGoods.Model.Product;

import java.util.Map;

public interface ProductService {
    Map<Integer, Product> productMapB(int count);

    Map<Integer, Product> productMapA(int count);
}
