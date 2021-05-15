package com.yangliuqing.information_security_lab4.controller;

import com.yangliuqing.information_security_lab4.dao.UserDAO;
import com.yangliuqing.information_security_lab4.vo.RegistryUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/** @author yang */
@Controller
@RequestMapping("/registry")
public class RegistryController {
    @Autowired private UserDAO userDAO;

    @GetMapping("")
    public String getRegistry(RegistryUserVO registryUserVO) {
        return "registry";
    }

    @PostMapping("")
    public String postRegistry(@Valid RegistryUserVO registryUserVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registry";
        }
        userDAO.save(registryUserVO.getUsername(), registryUserVO.getPassword());
        return "redirect:/login";
    }
}
