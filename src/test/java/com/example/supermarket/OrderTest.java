package com.example.supermarket;

import com.example.supermarket.entity.Order;
import com.example.supermarket.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class OrderTest {
    @Resource
    OrderService orderService;

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
