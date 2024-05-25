package com.example.cinemareservation.domain.core.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	@DisplayName("Money 의 생성자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_생성자초기화값_음수() {
		// WHEN
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> {
				Money money = new Money(BigDecimal.valueOf(-5000));
			});

		// THEN
		assertEquals("Amount must be positive and non-null", exception.getMessage());
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
		assertEquals("Amount must be positive and non-null", exception.getMessage());
	}

	@Test
	@DisplayName("Money.subAmount() 인자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_subAmount_인자값_음수() {
		// GIVEN
		Money money = new Money(BigDecimal.valueOf(5000));

		// WHEN
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> {
				money.subAmount(BigDecimal.valueOf(-5000));
			});

		// THEN
		assertEquals("Amount must be positive and non-null", exception.getMessage());
	}

	@Test
	@DisplayName("Money.multiplyAmount() 인자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_multiplyAmount_인자값_음수() {
		// GIVEN
		Money money = new Money(BigDecimal.valueOf(5000));

		// WHEN
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> {
				money.multiplyAmount(BigDecimal.valueOf(-5000));
			});

		// THEN
		assertEquals("Amount must be positive and non-null", exception.getMessage());
	}

	@Test
	@DisplayName("Money.divideAmount() 인자값으로 Negative 값이 들어온 경우 예외처리를 합니다.")
	void 예외_Money_divideAmount_인자값_음수() {
		// GIVEN
		Money money = new Money(BigDecimal.valueOf(5000));

		// WHEN
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> {
				money.divideAmount(BigDecimal.valueOf(-5000));
			});

		// THEN
		assertEquals("Amount must be positive and non-null", exception.getMessage());
	}
}