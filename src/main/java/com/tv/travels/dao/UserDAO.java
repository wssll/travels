package com.tv.travels.dao;

import com.tv.travels.entity.User;
import org.apache.ibatis.annotations.Mapper;


//@Mapper
public interface UserDAO {

    //根据用户名查询用户
    User findByUsername(String username);

    void save(User user);

}
