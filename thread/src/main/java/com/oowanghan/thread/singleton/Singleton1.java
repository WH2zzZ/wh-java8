package com.oowanghan.thread.thread.singleton;

/**
 * 饿汉式(静态常量)
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */

public class Singleton1 {

    private Singleton1(){}

    private static final Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }
}
