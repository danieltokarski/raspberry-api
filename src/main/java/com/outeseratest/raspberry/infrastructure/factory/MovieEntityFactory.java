package com.outeseratest.raspberry.infrastructure.factory;

import static com.outeseratest.raspberry.infrastructure.util.ProducerParserUtil.joinProducers;

import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.infrastructure.entity.MovieEntity;
import com.outeseratest.raspberry.infrastructure.util.ProducerParserUtil;

/**
 * Factory class for converting between {@link Movie} domain objects and {@link MovieEntity} persistence entities.
 */
public class MovieEntityFactory {

    /**
     * Converts a {@link Movie} domain object to a {@link MovieEntity} for persistence.
     *
     * @param movie the domain movie object to convert
     * @return the corresponding {@link MovieEntity}
     */
    public static MovieEntity toEntity(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setTitle(movie.getTitle());
        entity.setYear(movie.getYear());
        entity.setWinner(movie.isWinner());
        entity.setProducers(joinProducers(movie.getProducers()));
        return entity;
    }

    /**
     * Converts a {@link MovieEntity} persistence object to a {@link Movie} domain object.
     *
     * @param entity the persistence entity to convert
     * @return the corresponding {@link Movie} domain object
     */
    public static Movie toDomain(MovieEntity entity) {
        Movie movie = new Movie();
        movie.setTitle(entity.getTitle());
        movie.setYear(entity.getYear());
        movie.setWinner(entity.getWinner());
        movie.setProducers(ProducerParserUtil.parseProducers(entity.getProducers()));
        return movie;
    }
}
