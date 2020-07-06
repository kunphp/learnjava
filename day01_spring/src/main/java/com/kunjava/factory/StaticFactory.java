package com.kunjava.factory;

import com.kunjava.service.IAccountService;
import com.kunjava.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
