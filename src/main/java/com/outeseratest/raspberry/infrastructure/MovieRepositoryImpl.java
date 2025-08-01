package com.outeseratest.raspberry.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.domain.repository.MovieRepository;
import com.outeseratest.raspberry.infrastructure.entity.MovieEntity;
import com.outeseratest.raspberry.infrastructure.factory.MovieEntityFactory;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
	
    private final MovieJpaRepository jpaRepository;

    @Override
    public List<Movie> findAllWinners() {
        return jpaRepository.findByWinner(true)
                .stream()
                .map(MovieEntityFactory::toDomain)
                .collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void saveMovies(List<Movie> movies) {
		
        List<MovieEntity> list = movies
            .stream()
            .map(MovieEntityFactory::toEntity)
            .toList();
		
        jpaRepository.saveAll(list);
	}
	
}
