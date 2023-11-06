package com.example.supermarket.service.impl;

import com.example.supermarket.cons.Constants;
import com.example.supermarket.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public Integer queryGoodsPrice(String name) {
        for(String[] goods : Constants.GOODS){
            if(name.equals(goods[0])){
                return Integer.parseInt(goods[1]);
            }
        }
        return null;
    }
}
