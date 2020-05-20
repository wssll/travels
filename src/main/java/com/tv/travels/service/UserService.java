package com.tv.travels.service;

import com.tv.travels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding.Use;
import java.util.Map;

public interface UserService {

    Map<String,Object> register(User user);

    User login(User user);


}
