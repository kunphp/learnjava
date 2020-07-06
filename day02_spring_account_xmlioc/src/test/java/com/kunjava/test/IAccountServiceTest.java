package com.kunjava.test;


import com.kunjava.domain.Account;
import com.kunjava.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class IAccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        Account account = as.findAccountById(3);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(new BigDecimal(999.99));
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        as.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(BigDecimal.valueOf(99.99));
        account.setId(4);
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        as.deleteAccount(4);
    }
}
