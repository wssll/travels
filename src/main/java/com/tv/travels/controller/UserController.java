package com.tv.travels.controller;

import com.tv.travels.dto.UserDto;
import com.tv.travels.dto.group.UserGroup;
import com.tv.travels.entity.Result;
import com.tv.travels.entity.User;
import com.tv.travels.service.UserService;
import com.tv.travels.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

//    注入springboot配置好的redisTemplate
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 用户注册
     * @param key
     * @param userDto
     * @param bdresult
     * @param request
     * @return
     */
    @PostMapping("register")
    public Result register(String key, @Validated(UserGroup.ADD.class) @RequestBody UserDto userDto, BindingResult bdresult,
                           HttpServletRequest request) {
        Result result = new Result();
        if(bdresult.hasErrors()){
            return result.setMsg(bdresult.getFieldError().getDefaultMessage()).setState(false);
//             return Result.error().setState(false).setMsg(bdresult.getFieldError().getDefaultMessage());
        }
        log.info("接收的验证码 " + userDto.getCode());
        log.info("接收到的key对象 " + key);
        log.info("接收到的user对象 " + userDto);
//        验证验证码
        String keyCode = (String) request.getServletContext().getAttribute(key);
        log.info("keyCode " + keyCode);
        try {
            if (keyCode.equalsIgnoreCase(userDto.getCode())) {
//            注册用户
                User user = new User();
                BeanUtils.copyProperties(userDto,user);
                Map<String, Object> map = userService.register(user);
                return result.setState((Boolean) map.get("status")).setMsg((String) map.get("msg"));
            } else {
                return result.setState(false).setMsg("验证码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @PostMapping("login")
    public Result login(@RequestBody User user,HttpServletRequest request){
        Result result = new Result();
        log.info("user"+user);
        try {
            User userDB = userService.login(user);
//            保存用户的标记
            request.getServletContext().setAttribute(userDB.getId(),userDB);
            setRedis(userDB);
            result.setMsg("登录成功").setState(true).setUserId(userDB.getId());
        }catch (Exception e){
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    /**
     * Redis序列化存储用户信息
     * @param userDB
     */
    public void setRedis(User userDB) {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.opsForValue().set("userId",userDB.getId());
    }
}
