package com.kunjava.service.impl;

import com.kunjava.dao.AccountDao;
import com.kunjava.domain.Account;
import com.kunjava.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public List<Account> findAll(){
        System.out.println("Service：findAll...");
        return accountDao.findAll();
    }

    public void saveAccout(Account account){
        System.out.println("Service：saveAccout...");
        accountDao.saveAccount(account);
        return;
    }


}
