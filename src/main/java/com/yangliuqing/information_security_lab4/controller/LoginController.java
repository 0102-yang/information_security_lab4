package com.yangliuqing.information_security_lab4.controller;

import com.yangliuqing.information_security_lab4.vo.LoginUserVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/** @author yang */
@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("")
    public String getLogin(LoginUserVO loginUserVO) {
        return "login";
    }

    @PostMapping("")
    public String postLogin(@Valid LoginUserVO loginUserVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "result";
    }
}
