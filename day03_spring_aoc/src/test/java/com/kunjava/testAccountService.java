package com.kunjava;

import com.kunjava.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAccountService {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
//        Logger类中的aroundPringLog方法开始记录日志了。。。前置
//        执行了saveAccount
//        Logger类中的aroundPringLog方法开始记录日志了。。。后置
//        Logger类中的aroundPringLog方法开始记录日志了。。。最终
//        Logger类中的aroundPringLog方法开始记录日志了。。。前置
    }
}
