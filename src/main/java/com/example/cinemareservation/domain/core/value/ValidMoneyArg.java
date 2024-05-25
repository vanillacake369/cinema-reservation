package com.example.cinemareservation.domain.core.value;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidMoneyArgValidator.class)
@Target({PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface ValidMoneyArg {

	String message() default "Argument for Money value object must be positive or zero";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
