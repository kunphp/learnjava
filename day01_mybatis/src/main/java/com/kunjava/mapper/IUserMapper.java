package com.kunjava.mapper;

import com.kunjava.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
