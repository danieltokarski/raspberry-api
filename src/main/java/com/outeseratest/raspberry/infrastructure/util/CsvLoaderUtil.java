package com.outeseratest.raspberry.infrastructure.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class CsvLoaderUtil {

    public List<CSVRecord> loadCsv(String filename) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo CSV não encontrado: " + filename);
            }

            Reader reader = new InputStreamReader(inputStream);

            CSVFormat format = CSVFormat.Builder.create()
                    .setHeader()
                    .setDelimiter(';')
                    .setHeader("year", "title", "studios", "producers", "winner")
                    .setSkipHeaderRecord(true)
                    .setTrim(true)
                    .setIgnoreHeaderCase(true)
                    .build();

            return format.parse(reader).getRecords();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar CSV: " + filename, e);
        }
    }
}
