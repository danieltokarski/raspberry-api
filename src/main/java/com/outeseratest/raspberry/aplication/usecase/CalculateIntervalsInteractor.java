package com.outeseratest.raspberry.aplication.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.outeseratest.raspberry.domain.model.IntervalResult;
import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.domain.model.ProducerInterval;
import com.outeseratest.raspberry.domain.repository.MovieRepository;
import com.outeseratest.raspberry.domain.service.ProducerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculateIntervalsInteractor implements CalculateIntervalsUseCase {
	
    private final MovieRepository movieRepository;
    private final ProducerService producerService;
    
    public IntervalResult execute() {
    	
        List<Movie> vencedores = movieRepository.findAllWinners();
        List<ProducerInterval> intervalos = producerService.calculateIntervals(vencedores);

        if (intervalos.isEmpty()) {
            return new IntervalResult(List.of(), List.of());
        }

        int min = intervalos.stream().mapToInt(ProducerInterval::getInterval).min().orElse(0);
        int max = intervalos.stream().mapToInt(ProducerInterval::getInterval).max().orElse(0);

        List<ProducerInterval> minList = intervalos.stream()
                .filter(p -> p.getInterval() == min)
                .toList();

        List<ProducerInterval> maxList = intervalos.stream()
                .filter(p -> p.getInterval() == max)
                .toList();

        return new IntervalResult(minList, maxList);
    }
}
