package com.kunjava.dao;


import com.kunjava.domain.Account;

import java.util.List;
/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id获取账户
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id);
}
