package com.kunjava.proxy;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(final String[] args){
        /*
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不改变源码的基础上进行方法增强
         * 分类：①基于接口的动态代理②基于子类的动态代理
         *
         * 基于接口的动态代理
         * 创建代理对象：Proxy的newProxyInstance方法
         * 前提要求：被代理的类最少实现一个接口
         * newProxyInstance方法参数
         * ClassLoader：被代理对象的类加载器
         * class[]：字节数组，与代理对象拥有相同的方法，即实现同一个接口即可
         * InvocationHandler：用于增强的代码，一般都是写实现该接口的匿名内部类
         */
        final Producter producter = new Producter();
        IProducter  proxyProducter = (IProducter) Proxy.newProxyInstance(producter.getClass().getClassLoader(), producter.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * @param 0 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法所需的参数
             * @return 和被代理对象方法有相同返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object returnValue = null;
//                1、获取方法执行的参数
                Float money = (Float)objects[0];
//                生产厂商拿到80%,20%被代理拿走
                returnValue = method.invoke(producter,money*0.8f);//生产厂商拿到80%,20%被代理拿走
                return returnValue;
            }
        });
        proxyProducter.afterService(1000f);
        proxyProducter.saleProduct(10000f);
    }
}
