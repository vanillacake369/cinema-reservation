package com.example.cinemareservation.domain.core.value;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class ValidMoneyArgValidator implements ConstraintValidator<ValidMoneyArg, BigDecimal> {

	@Override
	public boolean isValid(BigDecimal amount, ConstraintValidatorContext constraintValidatorContext) {
		if (amount == null || amount.signum() <= 0) {
			throw new IllegalArgumentException("Amount to add must be positive and non-null");
		}
		return true;
	}
}
