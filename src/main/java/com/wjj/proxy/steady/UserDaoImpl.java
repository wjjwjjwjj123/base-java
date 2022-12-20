package com.wjj.proxy.steady;

import com.wjj.proxy.steady.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
    @Override
    public void sayHello() {
        System.out.println("i am method named sayHello.");
    }
}
