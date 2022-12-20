package com.wjj.proxy.dynamic;

public class Renter implements Person{

    @Override
    public void rentHouse() {
        System.out.println("租客租房成功");
    }
}
