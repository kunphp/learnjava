package com.kunjava.ui;

import com.kunjava.dao.IAccountDao;
import com.kunjava.service.IAccountService;
import com.kunjava.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IOC核心容器，根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1、获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        或
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        factory.getBean("accountService",IAccountService.class);

        //2、根据id获取对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
//        IAccountDao ad = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(ad);
        as.saveAccount();
    }
}
