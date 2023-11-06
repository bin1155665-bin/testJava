package com.example.supermarket.service.impl;

import com.example.supermarket.entity.Goods;
import com.example.supermarket.entity.Order;
import com.example.supermarket.service.GoodsService;
import com.example.supermarket.service.OrderService;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class OrderServiceImpl implements OrderService {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    public Order calculatingMoney(HashMap<Goods, Integer> goodsList, int reachMoney, int reduceMoney) {
        Order order = new Order();
        order.setGoodsList(goodsList);

        AtomicReference<Double> orderMoney = new AtomicReference<>(0d);
        goodsList.forEach((goods,count)->{
            Integer price = goodsService.queryGoodsPrice(goods.getName());

            // 草莓 8折
            if("草莓".equals(goods.getName())){
                orderMoney.updateAndGet(v -> v + price * count * 0.8);
            }

            orderMoney.updateAndGet(v -> v + price * count);
        });

        // 满减
        int n = (int) (orderMoney.get() / reachMoney);
        order.setOrderMoney(orderMoney.updateAndGet(v -> v - reduceMoney * n));
        return order;
    }
}
