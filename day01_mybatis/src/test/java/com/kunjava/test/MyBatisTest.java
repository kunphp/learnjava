package com.kunjava.test;


import com.kunjava.mapper.IUserMapper;
import com.kunjava.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        // 1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionfactory工厂
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sfb.build(in);
        //3、使用工厂的SqlSession对象
        SqlSession sqs = factory.openSession();
        //4、使用SqlSession创建Dao接口的代理对象
        IUserMapper userMap = sqs.getMapper(IUserMapper.class);
        //5、使用代理对象执行方法
        List<User> users = userMap.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //6、释放资源
        sqs.close();
        in.close();
    }
}
