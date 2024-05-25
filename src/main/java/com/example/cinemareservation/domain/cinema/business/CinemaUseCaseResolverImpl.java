package com.example.cinemareservation.domain.cinema.business;

import com.example.cinemareservation.domain.cinema.dto.request.ReservationRequestDto;
import com.example.cinemareservation.domain.cinema.dto.response.ReservationResponseDto;
import com.example.cinemareservation.domain.cinema.service.CinemaService;
import com.example.cinemareservation.domain.movie.validator.MovieValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CinemaUseCaseResolverImpl implements CinemaUseCaseResolver {

	private final CinemaService cinemaService;

	private final MovieValidator movieValidator;

	@Override
	public ReservationResponseDto handleReservation(ReservationRequestDto requestDto) {
		// validation layer
		movieValidator.validate(requestDto);

		// impl layer(service :: discount & reservation )
		return cinemaService.handleReservation();
	}
}
