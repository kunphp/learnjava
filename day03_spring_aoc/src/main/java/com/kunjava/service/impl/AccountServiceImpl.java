package com.kunjava.service.impl;

import com.kunjava.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行力saveAccount");
    }

    public void updateAccount(int money) {
        System.out.println("执行了updateAccount");
    }

    public int deleteAccount() {
        return 0;
    }
}
