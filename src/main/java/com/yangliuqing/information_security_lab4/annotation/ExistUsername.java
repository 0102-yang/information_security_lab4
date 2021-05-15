package com.yangliuqing.information_security_lab4.annotation;

import com.yangliuqing.information_security_lab4.validators.UsernameValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/** @author yang */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface ExistUsername {
    boolean exist();

    String message() default "";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
