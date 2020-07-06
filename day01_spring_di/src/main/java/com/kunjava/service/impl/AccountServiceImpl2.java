package com.kunjava.service.impl;

import com.kunjava.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
    private List list;
    private Map map;
    private Set set;
    private String[] arr;
    private Properties prop;

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public void  saveAccount(){
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(prop);

    }
}
