package com.kunjava.service.impl;

import com.kunjava.dao.IAccountDao;
import com.kunjava.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 账户的业务层实现类
 *
 *之前基于XML的配置
 *     <bean id="accountService1" class="com.kunjava.service.impl.AccountServiceImpl1"
 *     scope="" init-method="" destroy-method="">
 *         <property name="" value=""></property>
 *     </bean>
 *     用于创建对象的
 *          XML:bean标签
 *          Component:
 *              作用：把当前类对象存入Spring容器中
 *              属性：value:指定bean的id，不写时默认为当前类名，首字母小写
 *          Controller
 *          Service
 *          Repository
 *          以上三个注解作用和属性于Component一模一样，它们时Spring为我们提供明确的三层对象使用的注解
 *     用于注入数据的
 *          XML:property属性
 *     用于改变作用范围的
 *          XML:scope属性
 *     和生命周期相关的
 *          XML:init-method，destroy-method
 */
//注解方式
@Service(value = "accountService4")//value=可不写
@Scope
public class AccountServiceImpl4 implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
