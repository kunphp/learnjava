package com.kunjava.cglib;


/**
 * 一个生产者
 */
public class Producter{
    public void saleProduct(float money){
        System.out.println("销售产品,拿到钱："+money);
    }
    public void afterService(float money){
        System.out.println("产品售后服务，拿到钱："+money);
    }
}
