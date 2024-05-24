package com.example.cinemareservation.domain.cinema.dto.request;

public record ReservationRequestDto(
        String movieName,
        Integer seatCount
) {
}
