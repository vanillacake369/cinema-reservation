package com.example.cinemareservation.domain.cinema.dto.response;

import java.sql.Timestamp;

public record ReservationResponseDto(
        String movieName,
        Timestamp timestamp,
        Integer personCount,
        Long originalPaymentAmount,
        Long totalPaymentAmount
) {
}
