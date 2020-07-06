package com.kunjava.test;


import config.ProjectConfiguration;
import com.kunjava.domain.Account;
import com.kunjava.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * 使用Junit单元测试，测试我们的p配置
 * Spring整合Junit的配置
 *      1、导入spring整合junit的jar包(spring-test)
 *      2、使用junit提供的一个注解把原有的main方法替换成spring提供的@Runwith
 *      3、告知spring的运行器，spring和ioc的创建是基于xml还是注解，并位置位置
 *          //@ContextConfiguration:
 *              locations:指定xml文件的位置，加上classpath关键字
 *              classes:指定注解类的所在位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class IAccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
//        ApplicationContext ac = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = ac.getBean("accountService",IAccountService.class);
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        Account account = as.findAccountById(3);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(new BigDecimal(999.99));
        as.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(BigDecimal.valueOf(99.99));
        account.setId(5);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        as.deleteAccount(4);
    }
}
