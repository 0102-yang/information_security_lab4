package com.yangliuqing.information_security_lab4.dao;

import com.yangliuqing.information_security_lab4.doo.UserDO;
import com.yangliuqing.information_security_lab4.services.PasswordHashValueGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** @author yang */
@Repository
@Slf4j
public class UserDAO {
    @Autowired private JdbcTemplate jdbcTemplate;

    private static final String USER_NAME_COL_NAME = "username";

    private static final String PASSWORD_COL_NAME = "password_hash_value";

    private static final String SALT_COL_NAME = "salt";

    public UserDO selectByUsername(String username) {
        var listUser = jdbcTemplate.queryForList("select * from user where username = ?", username);
        if (listUser.size() != 1) {
            return null;
        }

        var map = listUser.get(0);
        return new UserDO(
                (String) map.get(USER_NAME_COL_NAME),
                (String) map.get(PASSWORD_COL_NAME),
                (String) map.get(SALT_COL_NAME));
    }

    public void save(String username, String password) {
        // todo: save function must be override
        String salt = UUID.randomUUID().toString();
        String passwordHashValue = PasswordHashValueGenerator.generate(username, password, salt);
        jdbcTemplate.update("insert into user values(?,?,?)", username, passwordHashValue, salt);
        log.info("Insert successfully");
    }

    public void deleteAll() {
        jdbcTemplate.update("delete from user");
        log.info("Delete all data successfully");
    }
}
