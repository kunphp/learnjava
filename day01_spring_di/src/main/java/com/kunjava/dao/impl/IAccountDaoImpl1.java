package com.kunjava.dao.impl;

import com.kunjava.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 */
@Repository("accountDao1")
public class IAccountDaoImpl1 implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户1111111");
    }
}
