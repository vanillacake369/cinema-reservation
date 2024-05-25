package com.example.cinemareservation.domain.cinema.dto.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record ReservationResponseDto(
	String movieName,
	Timestamp timestamp,
	Integer personCount,
	BigDecimal originalPaymentAmount,
	BigDecimal totalPaymentAmount
) {

}
