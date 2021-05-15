package com.yangliuqing.information_security_lab4.validators;

import com.yangliuqing.information_security_lab4.annotation.ExistUsername;
import com.yangliuqing.information_security_lab4.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** @author yang */
@Component
public class UsernameValidator implements ConstraintValidator<ExistUsername, String> {
    @Autowired private UserDAO userDAO;

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    private boolean exist;

    @Override
    public void initialize(ExistUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.exist = constraintAnnotation.exist();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("".equals(value)) {
            return true;
        }

        var rs = userDAO.selectByUsername(value);
        return exist == (rs != null);
    }
}
