package com.insurance.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = DateValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Date must be in the format 'yyyy-MM-dd' and should be older than 18 years.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

