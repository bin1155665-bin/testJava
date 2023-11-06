package com.example.supermarket.service;

import com.example.supermarket.entity.Goods;
import com.example.supermarket.entity.Order;

import java.util.HashMap;

public interface OrderService {
    Order calculatingMoney(HashMap<Goods,Integer> goods, int reachMoney, int reduceMoney);
}
