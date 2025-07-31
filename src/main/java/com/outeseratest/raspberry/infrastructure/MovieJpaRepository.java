package com.outeseratest.raspberry.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.outeseratest.raspberry.infrastructure.entity.MovieEntity;

/**
 * Repository interface for accessing {@link MovieEntity} data using Spring Data JPA.
 * <p>
 * Provides basic CRUD operations and custom queries related to movies.
 */
@Repository
public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {

    /**
     * Retrieves a list of {@link MovieEntity} objects that match the specified winner status.
     *
     * @param winner whether the movie is a winner
     * @return a list of movies with the given winner status
     */
    List<MovieEntity> findByWinner(boolean winner);

}
