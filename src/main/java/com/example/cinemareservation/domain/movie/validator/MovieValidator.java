package com.example.cinemareservation.domain.movie.validator;

import com.example.cinemareservation.domain.cinema.dto.request.ReservationRequestDto;
import com.example.cinemareservation.domain.movie.infra.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieValidator {

	private final MovieRepository movieRepository;

	public void validate(ReservationRequestDto requestDto) {

	}
}
