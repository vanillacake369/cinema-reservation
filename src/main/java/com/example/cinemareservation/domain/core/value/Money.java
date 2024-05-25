package com.example.cinemareservation.domain.core.value;

import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.MathContext;
import org.springframework.validation.annotation.Validated;

@Validated
public record Money(
	BigDecimal amount
) {

	/**
	 * custom constructor with validation
	 *
	 * @throws IllegalArgumentException when input amount is null || zero || negative
	 */
	public Money {
		validateAmount(amount);
	}

	private void validateAmount(BigDecimal amount) {
		if (amount == null || amount.signum() <= 0) {
			throw new IllegalArgumentException("Amount must be positive and non-null");
		}
	}

	public Money addAmount(BigDecimal amount) {
		validateAmount(amount);

		BigDecimal newAmount = this.amount.add(amount);

		return new Money(newAmount);
	}

	public Money subAmount(@PositiveOrZero BigDecimal amount) {
		validateAmount(amount);

		BigDecimal newAmount = this.amount.subtract(amount);

		return new Money(newAmount);
	}

	public Money multiplyAmount(@PositiveOrZero BigDecimal amount) {
		validateAmount(amount);

		BigDecimal newAmount = this.amount.multiply(amount);

		return new Money(newAmount);
	}

	public Money divideAmount(@PositiveOrZero BigDecimal amount) {
		validateAmount(amount);

		// Divide precision of the IEEE 754-2019 decimal32 format
		BigDecimal newAmount = this.amount.divide(amount, MathContext.DECIMAL32);

		return new Money(newAmount);
	}
}
