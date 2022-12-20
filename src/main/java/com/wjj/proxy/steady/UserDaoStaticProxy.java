package com.wjj.proxy.steady;

import com.wjj.proxy.steady.dao.IUserDao;

public class UserDaoStaticProxy implements IUserDao {

    private IUserDao target;
    public UserDaoStaticProxy(IUserDao target){
        this.target = target;
    }

    @Override
    public void sayHello() {
        System.out.println("before");
        target.sayHello();
        System.out.println("after");
    }
}
