package com.outeseratest.raspberry.domain.repository;

import java.util.List;

import com.outeseratest.raspberry.domain.model.Movie;

/**
 * Repository interface for accessing and persisting Movie data.
 * 
 * Provides methods to retrieve winning movies and to save a list of movies.
 */
public interface MovieRepository {
    
    /**
     * Retrieves a list of all movies that are winners.
     * 
     * @return a list of {@link Movie} objects where each movie is marked as a winner.
     */
    List<Movie> findAllWinners();
    
    /**
     * Persists a list of movies.
     * 
     * @param movies the list of {@link Movie} objects to be saved.
     */
    void saveMovies(List<Movie> movies);
}
