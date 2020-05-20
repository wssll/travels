package com.tv.travels;

import com.tv.travels.entity.User;
import com.tv.travels.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = TravelsApplication.class)
public class TravelsApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("xiaolei");
        user.setPassword("666");
        user.setEmail("xiaochen@qq.com");
        userService.register(user);
    }
}