package com.example.cinemareservation.domain.movie.entity;

import com.example.cinemareservation.domain.cinema.entity.CinemaMovie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "movie")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotEmpty
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "movie", targetEntity = CinemaMovie.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<CinemaMovie> movies = new ArrayList<>();

	@Builder
	private Movie(String name) {
		this.name = name;
	}
}
