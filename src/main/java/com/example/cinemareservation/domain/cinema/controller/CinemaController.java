package com.example.cinemareservation.domain.cinema.controller;

import com.example.cinemareservation.domain.cinema.business.CinemaUseCaseResolver;
import com.example.cinemareservation.domain.cinema.dto.request.ReservationRequestDto;
import com.example.cinemareservation.domain.cinema.dto.response.ReservationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaUseCaseResolver cinemaUseCaseResolver;

    /**
     * 영화 & 좌석 예약
     */
    @PostMapping("/reserve")
    public ResponseEntity<?> reserveCinema(
        @RequestBody ReservationRequestDto requestDto
    ){
        ReservationResponseDto responseDto = cinemaUseCaseResolver.handleReservation(requestDto);
        return ResponseEntity.ok()
                .body(responseDto);
    }
}
