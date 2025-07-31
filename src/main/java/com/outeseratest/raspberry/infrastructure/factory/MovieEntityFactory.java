package com.outeseratest.raspberry.infrastructure.factory;

import static com.outeseratest.raspberry.infrastructure.util.ProducerParserUtil.joinProducers;

import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.infrastructure.entity.MovieEntity;
import com.outeseratest.raspberry.infrastructure.util.ProducerParserUtil;

public class MovieEntityFactory {

    public static MovieEntity toEntity(Movie movie) {
    	
        MovieEntity entity = new MovieEntity();
        entity.setTitle(movie.getTitle());
        entity.setYear(movie.getYear());
        entity.setWinner(movie.isWinner());
        entity.setProducers(joinProducers(movie.getProducers()));
        
        return entity;
    }
    
    public static Movie toDomain(MovieEntity entity) {
    	
        Movie movie = new Movie();
        movie.setTitle(entity.getTitle());
        movie.setYear(entity.getYear());
        movie.setWinner(entity.getWinner());
        movie.setProducers(ProducerParserUtil.parseProducers(entity.getProducers()));
        
        return movie;
    }
}
