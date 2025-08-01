package com.outeseratest.raspberry.infrastructure.config;

import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.outeseratest.raspberry.aplication.usecase.MovieSaveUseCase;
import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.infrastructure.util.CsvLoaderUtil;
import com.outeseratest.raspberry.infrastructure.util.ProducerParserUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CsvDataLoader {

   private final MovieSaveUseCase movieSaveUseCase;
   private final CsvLoaderUtil csvLoaderUtil;

   @Value("${app.csv.csv-path-movies-import}")
   private String csvFilePath;
	 
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
	public void loadCsvOnStartup() {
		List<CSVRecord> records = csvLoaderUtil.loadCsv(csvFilePath);

        List<Movie> movies = records.stream().map(record -> {
        	Movie movie = new Movie();
            movie.setYear(Integer.parseInt(record.get("year")));
            movie.setTitle(record.get("title"));
            movie.setProducers(ProducerParserUtil.parseProducers(record.get("producers")));
            movie.setWinner("yes".equalsIgnoreCase(record.get("winner")));
            return movie;
        }).toList();

        movieSaveUseCase.execute(movies);
        System.out.println("Importação do CSV concluída. Total: " + movies.size());
    }	
}
