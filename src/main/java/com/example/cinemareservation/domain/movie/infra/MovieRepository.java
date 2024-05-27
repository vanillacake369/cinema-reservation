package com.example.cinemareservation.domain.movie.infra;

import com.example.cinemareservation.domain.movie.entity.Movie;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	Optional<Movie> findByName(String name);

}
