package com.wjj.proxy.cglibdynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory<T> implements MethodInterceptor {

    private T obj;

    public ProxyFactory(T obj) {
        this.obj = obj;
    }

    public T getProxy() {
        // 1.创建Enhancer对象，它类似于咱们JDK动态代理中的proxy类，该类是用来获取代理对象的
        Enhancer enhancer = new Enhancer();
        // 2.设置父类的字节码对象。为啥子要这样做呢？因为使用cglib生成的代理类是属于目标类的子类的，也就是说代理类是要继承自目标类的
        enhancer.setSuperclass(obj.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建代理对象
        return (T) enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("makeCloth")){
            System.out.println("制作服装前的准备........");
        }
        Object invoke = method.invoke(obj,objects);
        if(method.getName().equals("makeCloth")){
            System.out.println("对制作好的服装打包处理");
        }
        return invoke;
    }
}
