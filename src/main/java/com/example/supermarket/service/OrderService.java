package com.example.supermarket.service;

import com.example.supermarket.entity.Goods;
import com.example.supermarket.entity.Order;

import java.util.HashMap;

public interface OrderService {
    Order calculatingMoney(HashMap<String,Integer> goods, Boolean saleFlag, Boolean flag);
}
