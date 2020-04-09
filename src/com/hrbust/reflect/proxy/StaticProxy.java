package com.hrbust.reflect.proxy;

/**
 * @program: reviewJava
 * @description: 静态代理,编译的时候就已经确定代理对象和被代理对象,不同的接口有不同的代理类
 * @author: Abner
 * @create: 2020-03-13 13:01
 */
//生产衣服的工厂
interface ClothFactory {
    void produce();
}

/**
 * 被代理类
 */
class Armani implements ClothFactory {


    @Override
    public void produce() {
        System.out.println("生产Armani");
    }
}

/**
 * 代理类
 */
class Proxy implements ClothFactory {
    private ClothFactory clothFactory;

    public Proxy(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }


    @Override
    public void produce() {
        clothFactory.produce();
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        Armani armani = new Armani();
        Proxy proxy = new Proxy(armani);
        proxy.produce();

    }


}
