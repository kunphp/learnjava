package com.kunjava.test;

import com.kunjava.mapper.IUserMapper;
import com.kunjava.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 测试mybatis的crud操作
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserMapper userMap;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取mapper的代理对象
        userMap = sqlSession.getMapper(IUserMapper.class);
    }
    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        //5.执行查询所有方法
        List<User> users = userMap.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //User{id=1, username='老王', address='上海市', sex='男', birthday=Wed Jul 08 00:00:00 CST 2020}
        //User{id=2, username='小王', address='北京市', sex='女', birthday=Thu Jul 09 00:00:00 CST 2020}
    }
    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("帅小伙");
        user.setUserAddress("南京市");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前："+user);
        userMap.saveUser(user);
        System.out.println("保存操作之后："+user);
        //保存操作之前：User{id=null, username='帅小伙', address='南京市', sex='男', birthday=Fri Jul 10 14:45:19 CST 2020}
        //保存操作之后：User{id=3, username='帅小伙', address='南京市', sex='男', birthday=Fri Jul 10 14:45:19 CST 2020}
    }
    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(3);
        user.setUserName("新名字");
        userMap.updateUser(user);
    }
    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        userMap.deleteUser(1);
    }
    /**
     * 测试删除操作
     */
    @Test
    public void testFindOne(){
        User  user = userMap.findById(2);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        //5.执行查询一个方法
        List<User> users = userMap.findByName("新%");
        for(User user : users){
            System.out.println(user);
        }
    }
    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        //5.执行查询一个方法
        int count = userMap.findTotal();
        System.out.println(count);
    }

    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUserSex("女");
        List<User> users = userMap.findByCondition(user);
        for (User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindByIdIn(){
        Set<Integer> ids = new TreeSet<Integer>();
        ids.add(1);
        ids.add(3);
        List<User> users = userMap.findByIdIn(ids);
        for (User u:users){
            System.out.println(u);
        }
        //User{id=1, username='老王', address='上海市', sex='男', birthday=Wed Jul 08 00:00:00 CST 2020}
        //User{id=3, username='新名字', address='南京市', sex='男', birthday=Fri Jul 10 00:00:00 CST 2020}
    }
}
