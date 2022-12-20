package com.wjj.proxy;

import com.wjj.proxy.steady.UserDaoImpl;
import com.wjj.proxy.steady.UserDaoStaticProxy;
import com.wjj.proxy.steady.dao.IUserDao;

public class StaticProxyTest {

    public static void main(String[] args){
        // 目标对象
        IUserDao target = new UserDaoImpl();
        // 代理对象
        UserDaoStaticProxy proxy = new UserDaoStaticProxy(target);
        // 调用代理方法
        proxy.sayHello();
    }

}
