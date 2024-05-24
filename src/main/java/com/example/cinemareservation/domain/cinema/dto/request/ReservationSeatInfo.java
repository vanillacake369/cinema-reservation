package com.example.cinemareservation.domain.cinema.dto.request;

public record ReservationSeatInfo(
        ClientAgeType clientAgeType,
        Integer seatCount
) {
}
