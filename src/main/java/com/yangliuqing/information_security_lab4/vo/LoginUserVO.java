package com.yangliuqing.information_security_lab4.vo;

import com.yangliuqing.information_security_lab4.annotation.CorrectLoginPassword;
import com.yangliuqing.information_security_lab4.annotation.ExistUsername;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/** @author yang */
@Data
@CorrectLoginPassword(message = "Password is not correct")
public class LoginUserVO {
    @NotBlank(message = "Login username can not be blank")
    @ExistUsername(exist = true, message = "Username is not exist")
    private String username;

    @NotBlank(message = "Login password can not be blank")
    private String password;
}
