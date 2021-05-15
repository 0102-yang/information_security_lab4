package com.yangliuqing.information_security_lab4.annotation;

import com.yangliuqing.information_security_lab4.validators.RegistryPasswordValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/** @author yang */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegistryPasswordValidator.class)
public @interface RegistryPassword {
    String message() default "";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
