package com.yangliuqing.information_security_lab4;

import com.yangliuqing.information_security_lab4.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @author yang */
@SpringBootApplication
public class InformationSecurityLab4Application implements CommandLineRunner {
    @Autowired private UserDAO userDAO;

    public static void main(String[] args) {
        SpringApplication.run(InformationSecurityLab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userDAO.deleteAll();

        userDAO.save("root", "root");
        userDAO.save("yangliuqing", "123456");
    }
}
