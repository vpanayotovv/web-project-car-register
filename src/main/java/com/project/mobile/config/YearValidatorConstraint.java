package com.project.mobile.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = YearValidator.class)
public @interface YearValidatorConstraint {

    String message() default "Invalid year";

    int minYear();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
