package com.yangliuqing.information_security_lab4.annotation;

import com.yangliuqing.information_security_lab4.validators.CorrectLoginValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/** @author yang */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectLoginValidator.class)
public @interface CorrectLoginPassword {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
