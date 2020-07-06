package com.kunjava.factory;


import com.kunjava.service.IAccountService;
import com.kunjava.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
