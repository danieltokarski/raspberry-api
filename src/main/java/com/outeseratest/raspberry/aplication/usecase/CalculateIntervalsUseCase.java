package com.outeseratest.raspberry.aplication.usecase;

import com.outeseratest.raspberry.domain.model.IntervalResult;

/**
 * Use case interface for calculating intervals.
 */
public interface CalculateIntervalsUseCase {

    /**
     * Executes the interval calculation use case.
     * 
     * @return the result of the interval calculation encapsulated in {@link IntervalResult}
     */
    IntervalResult execute();
}
