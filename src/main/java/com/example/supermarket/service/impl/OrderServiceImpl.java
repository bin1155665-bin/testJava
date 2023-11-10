package com.example.supermarket.service.impl;

import com.example.supermarket.entity.Goods;
import com.example.supermarket.entity.Order;
import com.example.supermarket.service.GoodsService;
import com.example.supermarket.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;


@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private GoodsService goodsService;

    @Override
    public Order calculatingMoney(HashMap<String, Integer> goodsList, Boolean saleFlag, Boolean flag) {
        Order order = new Order();

        HashMap<Goods,Integer> goods = new HashMap<>();
        AtomicReference<Double> orderMoney = new AtomicReference<>(0d);
        try{
            goodsList.forEach((name,count)->{
                Integer price = goodsService.queryGoodsPrice(name);
                goods.put(new Goods(name,price),count);

                // strawberry 8折
                if(saleFlag && "strawberry".equals(name)){
                    orderMoney.updateAndGet(v -> v + price * count * 0.8);
                }else{
                    orderMoney.updateAndGet(v -> v + price * count);
                }
            });

            // 满减
            int n = !flag?0:(int) (orderMoney.get() / 100);
            order.setOrderMoney(orderMoney.updateAndGet(v -> v - 10 * n));
            order.setGoodsList(goods);
        }catch (Exception e){
            return null;
        }

        return order;
    }
}
