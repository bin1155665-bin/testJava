package com.example.supermarket;

import com.example.supermarket.entity.Order;
import com.example.supermarket.service.OrderService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
        goodsList.put("apple",8);
        goodsList.put("strawberry",7);

        Order order = orderService.calculatingMoney(goodsList,false,false);

        Assertions.assertNotNull(order,"断言失败，订单为空");
        Assertions.assertEquals(order.getOrderMoney(),155,"断言失败，与预期金额不匹配");

        System.out.println(order);
    }

    @Test
    public void orderB(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("apple",8);
        goodsList.put("strawberry",7);
        goodsList.put("mango",10);

        Order order = orderService.calculatingMoney(goodsList,false,false);

        Assertions.assertNotNull(order,"断言失败，订单为空");
        Assertions.assertEquals(order.getOrderMoney(),355,"断言失败，与预期金额不匹配");

        System.out.println(order);
    }

    @Test
    public void orderC(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("apple",8);
        goodsList.put("strawberry",7);
        goodsList.put("mango",10);

        Order order = orderService.calculatingMoney(goodsList,true,false);

        Assertions.assertNotNull(order,"断言失败，订单为空");
        Assertions.assertEquals(order.getOrderMoney(),336.8,"断言失败，与预期金额不匹配");

        System.out.println(order);
    }

    @Test
    public void orderD(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("apple",8);
        goodsList.put("strawberry",7);
        goodsList.put("mango",10);

        Order order = orderService.calculatingMoney(goodsList,true,true);

        Assertions.assertNotNull(order,"断言失败，订单为空");
        Assertions.assertEquals(order.getOrderMoney(),306.8,"断言失败，与预期金额不匹配");

        System.out.println(order);
    }


    /**
     * 边界值测试
     * */
    @Test
    public void orderE(){
        HashMap<String,Integer> goodsList = new HashMap<>();
        goodsList.put("apple",100);
        goodsList.put("strawberry",100);
        goodsList.put("mango",10);

        Order order = orderService.calculatingMoney(goodsList,false,true);

        Assertions.assertNotNull(order,"断言失败，订单为空");
        Assertions.assertEquals(order.getOrderMoney(),2070,"断言失败，应为满100减10");

        System.out.println(order);
    }
}
