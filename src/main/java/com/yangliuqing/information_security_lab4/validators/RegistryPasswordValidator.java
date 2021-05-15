package com.yangliuqing.information_security_lab4.validators;

import com.yangliuqing.information_security_lab4.annotation.RegistryPassword;
import com.yangliuqing.information_security_lab4.vo.RegistryUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** @author yang */
@Slf4j
@Component
public class RegistryPasswordValidator
        implements ConstraintValidator<RegistryPassword, RegistryUserVO> {
    @Override
    public void initialize(RegistryPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegistryUserVO value, ConstraintValidatorContext context) {
        if ("".equals(value.getPassword()) || "".equals(value.getConfirmPassword())) {
            return true;
        }

        return value.getPassword().equals(value.getConfirmPassword());
    }
}
