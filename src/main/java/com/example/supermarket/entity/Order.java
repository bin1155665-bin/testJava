package com.example.supermarket.entity;

import lombok.Data;

import java.util.HashMap;

@Data
public class Order {
    private HashMap<Goods,Integer> goodsList;
    private Double orderMoney;
}
