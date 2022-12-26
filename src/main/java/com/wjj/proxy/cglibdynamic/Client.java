package com.wjj.proxy.cglibdynamic;

public class Client {
    public static void main(String[] args){
        NaiKeCloth cloth = new NaiKeCloth();
        NaiKeCloth proxy = new ProxyFactory<NaiKeCloth>(cloth).getProxy();
        proxy.makeCloth("短袖");
        String brand = proxy.brand();
        System.out.println(brand);
    }
}
