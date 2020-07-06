package com.kunjava.service.impl;

import com.kunjava.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl1 implements IAccountService {
    private String name;
    private Integer age;
    private Date date;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
        System.out.println("name:"+name+",age:"+age+",data:"+date);
    }
}
