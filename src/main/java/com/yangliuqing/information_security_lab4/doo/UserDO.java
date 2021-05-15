package com.yangliuqing.information_security_lab4.doo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author yang */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    private String username;

    private String password;

    private String salt;
}
