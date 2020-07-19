package com.kunjava.service;

import com.kunjava.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public void saveAccout(Account account);
}
