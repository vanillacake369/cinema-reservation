package com.example.cinemareservation.domain.core.value;

import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.validation.ConstraintViolationException;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	@DisplayName("Money 의 생성자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_생성자초기화값_음수() {
		// WHEN
		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
			() -> {
				Money money = new Money(BigDecimal.valueOf(-5000));
			});

		// THEN
		System.out.println("exception.getMessage() = " + exception.getMessage());
	}

	@Test
	@DisplayName("Money.addAmount() 인자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_addAmount_인자값_음수() {
		// GIVEN
		Money money = new Money(BigDecimal.valueOf(5000));

		// WHEN
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> {
				money.addAmount(BigDecimal.valueOf(-5000));
			});

		// THEN
		System.out.println("exception.getMessage() = " + exception.getMessage());
	}
}