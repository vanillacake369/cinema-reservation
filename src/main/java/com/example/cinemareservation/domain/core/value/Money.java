package com.example.cinemareservation.domain.core.value;

import java.math.BigDecimal;

public record Money(
	@ValidMoneyArg BigDecimal amount
) {

	public Money addAmount(BigDecimal amountToAdd) {
		if (amountToAdd == null || amountToAdd.signum() <= 0) {
			throw new IllegalArgumentException("Amount to add must be positive and non-null");
		}

		BigDecimal newAmount = this.amount.add(amountToAdd);

		return new Money(newAmount);
	}

	public Money subAmount(BigDecimal amountToAdd) {
		if (amountToAdd == null || amountToAdd.signum() <= 0) {
			throw new IllegalArgumentException("Amount to add must be positive and non-null");
		}

		BigDecimal newAmount = this.amount.subtract(amountToAdd);

		return new Money(newAmount);
	}
}
