package com.yangliuqing.information_security_lab4.services;

import org.springframework.stereotype.Component;

import java.util.Base64;

/** @author yang */
@Component
public class PasswordHashValueGenerator {
    public static String generate(String username, String originalPassword, String salt) {
        int hashCode = (originalPassword + salt).hashCode();
        String hashValue = hashCode + username;
        return Base64.getEncoder().encodeToString(hashValue.getBytes());
    }
}
