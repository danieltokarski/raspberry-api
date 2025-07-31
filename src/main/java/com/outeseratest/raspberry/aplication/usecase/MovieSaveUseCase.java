package com.outeseratest.raspberry.aplication.usecase;

import java.util.List;

import com.outeseratest.raspberry.domain.model.Movie;

/**
 * Use case interface for saving a list of movies.
 */
public interface MovieSaveUseCase {

    /**
     * Executes the use case to save a list of movies.
     * 
     * @param movies the list of movies to be saved
     */
    void execute(List<Movie> movies);
}
