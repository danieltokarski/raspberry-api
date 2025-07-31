package com.outeseratest.raspberry.aplication.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.domain.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieSaveInteractor implements MovieSaveUseCase {

	private final MovieRepository movieRepository;
	
	@Override
	public void execute(List<Movie> movies) {
		
		movieRepository.saveMovies(movies);
		
	}
}
