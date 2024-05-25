package com.example.cinemareservation.domain.cinema.business;

import com.example.cinemareservation.domain.cinema.dto.request.ReservationRequestDto;
import com.example.cinemareservation.domain.cinema.dto.response.ReservationResponseDto;

public interface CinemaUseCaseResolver {
    ReservationResponseDto handleReservation(ReservationRequestDto requestDto);
}
