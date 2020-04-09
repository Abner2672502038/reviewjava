package com.hrbust.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: reviewJava
 * @description: 动态代理
 * @author: Abner
 * @create: 2020-03-13 13:08
 */
//被代理类的接口
interface Human {
    String getName();

    void eat(String food);
}

/**
 * 被代理类
 */
class SupperMan implements Human {

    @Override
    public String getName() {
        return "超人";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃" + food);
    }
}

/**
 * 代理工厂
 */
class ProxyFactory {


    public Object getProxyInstance(Object object) {
        Invocation invocation = new Invocation();
        invocation.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), invocation);
    }

}

class Invocation implements InvocationHandler {
    //创建被代理对象
    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

//代理对象就调用invoke()方法

    /**
     *
     * @param proxy 代理对象
     * @param method 代理对象调用的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(object, args);
        return obj;
    }
}


public class DynamicProxy {
    public static void main(String[] args) {
        SupperMan supperMan = new SupperMan();
        ProxyFactory proxyFactory = new ProxyFactory();
        Human proxyHuman = (Human) proxyFactory.getProxyInstance(supperMan);
        String name = proxyHuman.getName();
        System.out.print(name);
        proxyHuman.eat("肯德基");


        Armani armani = new Armani();
        ClothFactory proxyInstance = (ClothFactory) proxyFactory.getProxyInstance(armani);
        proxyInstance.produce();
    }

}
