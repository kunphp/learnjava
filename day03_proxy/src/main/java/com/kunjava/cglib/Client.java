package com.kunjava.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(final String[] args){
        final Producter producter = new Producter();
        /*
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不改变源码的基础上进行方法增强
         * 分类：①基于接口的动态代理②基于子类的动态代理
         *
         * 基于子类的动态代理
         * 涉及类：Enhancer
         * 创建代理对象：Enhancer的create方法
         * 要求：被代理的类不能是最终类
         * create参数
         * class：被代理对象的字节码
         * callback：一般写的是该接口的子接口实现类
         * InvocationHandler：用于增强的代码，一般都是写实现该接口的匿名内部类
         */
        Producter enhancerProducter = (Producter) Enhancer.create(producter.getClass(), new MethodInterceptor() {
            /**
             * 执行该对象的任何方法都经过此方法
             * @param o
             * @param method
             * @param objects
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                // 1、获取方法执行的参数
                Float money = (Float)objects[0];
                //2、生产厂商拿到80%,20%被代理拿走
                returnValue = method.invoke(producter,money*0.8f);
                return returnValue;
            }
        });
        enhancerProducter.afterService(4000f);
    }
}
