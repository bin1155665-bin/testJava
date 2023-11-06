package com.example.supermarket.entity;

import lombok.Data;

@Data
public class Goods {
    private String name;
    private int price;

    public Goods(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Goods(){

    }
}
