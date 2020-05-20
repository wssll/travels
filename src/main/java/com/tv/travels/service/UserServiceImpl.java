package com.tv.travels.service;

import com.tv.travels.dao.UserDAO;
import com.tv.travels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public Map<String,Object> register(User user) {
        Map<String,Object> map = new HashMap<>();
        if(userDAO.findByUsername(user.getUsername())==null){
            userDAO.save(user);
            map.put("status",true);
            map.put("msg","添加成功");
            return map;
        }else {
            map.put("status",false);
            map.put("msg","用户已存在");
            return map;
        }
    }

    @Override
    public User login(User user) {
        User userDB =  userDAO.findByUsername(user.getUsername());
        if(userDB!=null){
            if(user.getPassword().equals(userDB.getPassword())){
                return userDB;
            }
            throw new RuntimeException("用户名或密码错误");
        }else {
            throw new RuntimeException("用户名不存在");
        }
    }
}
