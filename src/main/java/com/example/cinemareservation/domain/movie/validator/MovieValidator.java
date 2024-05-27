package com.example.cinemareservation.domain.movie.validator;

import com.example.cinemareservation.domain.cinema.dto.request.ReservationRequestDto;
import com.example.cinemareservation.domain.movie.infra.MovieRepository;
import com.example.cinemareservation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieValidator {

	private final MovieRepository movieRepository;

	public void validate(ReservationRequestDto requestDto) {
		if (movieRepository.findByName(requestDto.movieName()).isEmpty()) {
			throw new ResourceNotFoundException();
		}
	}
}
