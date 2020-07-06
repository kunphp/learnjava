package com.kunjava.service.impl;

import com.kunjava.dao.IAccountDao;
import com.kunjava.dao.impl.AccountDaoImpl;
import com.kunjava.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
        accountDao.saveAccount();
    }
}
