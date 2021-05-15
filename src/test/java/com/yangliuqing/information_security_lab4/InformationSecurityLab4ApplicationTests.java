package com.yangliuqing.information_security_lab4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class InformationSecurityLab4ApplicationTests {
    @Autowired private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        var rs = jdbcTemplate.queryForMap("select * from user where username = ?", "yangliuqing");
        System.out.println(rs);
    }
}
