package com.yangliuqing.information_security_lab4.validators;

import com.yangliuqing.information_security_lab4.annotation.CorrectLoginPassword;
import com.yangliuqing.information_security_lab4.dao.UserDAO;
import com.yangliuqing.information_security_lab4.services.PasswordHashValueGenerator;
import com.yangliuqing.information_security_lab4.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** @author yang */
@Component
public class CorrectLoginValidator
        implements ConstraintValidator<CorrectLoginPassword, LoginUserVO> {
    @Autowired private UserDAO userDAO;

    @Autowired private UsernameValidator existUsernameValidator;

    @Override
    public void initialize(CorrectLoginPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoginUserVO value, ConstraintValidatorContext context) {
        existUsernameValidator.setExist(false);
        if (existUsernameValidator.isValid(value.getUsername(), context)
                || "".equals(value.getPassword())) {
            return true;
        }

        var rs = userDAO.selectByUsername(value.getUsername());
        if (rs == null) {
            return false;
        }

        var originPassword = rs.getPassword();
        var salt = rs.getSalt();

        return PasswordHashValueGenerator.generate(value.getUsername(), value.getPassword(), salt)
                .equals(originPassword);
    }
}
