package com.example.supermarket;

import com.example.supermarket.entity.Goods;
import com.example.supermarket.entity.Order;
import com.example.supermarket.service.OrderService;
import com.example.supermarket.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class OrderTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void orderA(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("苹果",8);
        goodsList.put("草莓",7);

        Order order = orderService.calculatingMoney(goodsList,false,false);
        System.out.println(order);
    }

    @Test
    public void orderB(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("苹果",8);
        goodsList.put("草莓",7);
        goodsList.put("芒果",10);

        Order order = orderService.calculatingMoney(goodsList,false,false);
        System.out.println(order);
    }

    @Test
    public void orderC(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("苹果",8);
        goodsList.put("草莓",7);
        goodsList.put("芒果",10);

        Order order = orderService.calculatingMoney(goodsList,true,false);
        System.out.println(order);
    }

    @Test
    public void orderD(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("苹果",8);
        goodsList.put("草莓",7);
        goodsList.put("芒果",10);

        Order order = orderService.calculatingMoney(goodsList,true,true);
        System.out.println(order);
    }
}
