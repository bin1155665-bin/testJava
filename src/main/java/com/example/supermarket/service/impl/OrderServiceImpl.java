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

    /**
     *
     * 计算订单
     * goodsList：商品。件数
     * saleFlag：是否参与草莓打8折
     * flag：是否参加满减活动
     * */
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

            // 满100就减10
            int n = !flag?0:(int) (orderMoney.get() / 100);
            order.setOrderMoney(orderMoney.updateAndGet(v -> v - 10 * n));
            order.setGoodsList(goods);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return order;
    }
}
