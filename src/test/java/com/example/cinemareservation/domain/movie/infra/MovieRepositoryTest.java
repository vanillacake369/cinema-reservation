package com.example.cinemareservation.domain.movie.infra;

import com.example.cinemareservation.annotation.DataTest;
import com.example.cinemareservation.domain.movie.entity.Movie;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataTest
class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;

	@BeforeEach
	void setUp() {
		Movie movie = Movie.builder()
			.name("movie_1_name")
			.build();
		movieRepository.save(movie);
	}

	@Test
	@DisplayName("test should be")
	void testShouldBe() {
		// GIVEN
		List<Movie> all = movieRepository.findAll();

		// WHEN
		for (Movie movie : all) {
			System.out.println("movie = " + movie);
		}

		// THEN
//		fail("Not implemented");
	}
}