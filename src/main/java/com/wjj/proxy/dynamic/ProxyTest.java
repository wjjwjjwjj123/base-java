package com.wjj.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args){
        // 创建被代理的实例对象
        Person renter = new Renter();
        // 创建InvocationHandler对象
        InvocationHandler renterHandler = new RenterInvocationHandler<Person>(renter);

        //创建代理对象，代理对象的每个执行方法都会替代执行Invocation中的invoke方法
        Person renterProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},renterHandler);
        renterProxy.rentHouse();
    }
}
