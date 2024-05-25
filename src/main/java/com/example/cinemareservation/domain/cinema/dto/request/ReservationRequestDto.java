package com.example.cinemareservation.domain.cinema.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record ReservationRequestDto(
	@NotEmpty String movieName,
	@Positive Integer seatCount
) {

}
