package com.yangliuqing.information_security_lab4.vo;

import com.yangliuqing.information_security_lab4.annotation.ExistUsername;
import com.yangliuqing.information_security_lab4.annotation.RegistryPassword;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/** @author yang */
@Data
@RegistryPassword(message = "Password and confirm password is not correspond")
public class RegistryUserVO {
    @NotBlank(message = "Username can not be blank")
    @ExistUsername(exist = false, message = "This username is already been used")
    private String username;

    @Length(min = 6, max = 32, message = "The length of the password must between 6 and 32")
    private String password;

    @NotBlank(message = "Confirm password can not be blank")
    private String confirmPassword;
}
