package com.kunjava.ui;


import com.kunjava.service.IAccountService;
import com.kunjava.service.impl.AccountServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IOC核心容器，根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //方式一1、通过XML配置获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2、根据id获取对象
//        IAccountService as = ac.getBean("accountService",IAccountService.class);
//        IAccountService as = ac.getBean("accountService1",IAccountService.class);
//        IAccountService as = ac.getBean("accountService2",IAccountService.class);
        IAccountService as = ac.getBean("accountService4",IAccountService.class);
        IAccountService as2 = ac.getBean("accountService4",IAccountService.class);
        System.out.println(as == as2);
        as.saveAccount();
    }
}
