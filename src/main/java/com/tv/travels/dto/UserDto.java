package com.tv.travels.dto;

import com.tv.travels.dto.group.UserGroup.ADD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @NotEmpty(message = "用户名不能为空",groups = ADD.USERNAME.class)
    private String username;
    @NotEmpty(message = "密码不能为空",groups = ADD.PASSWORD.class)
    private String password;
    @NotEmpty(message = "邮箱不能为空",groups = ADD.EMAIL.class)
    @Email(message = "需要输入邮箱格式",groups = ADD.EMAIL.class,regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
    @NotEmpty(message = "验证码不能为空",groups = ADD.CODE.class)
    private String code;


}
