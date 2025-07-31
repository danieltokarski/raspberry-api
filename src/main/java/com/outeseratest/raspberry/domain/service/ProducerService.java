package com.outeseratest.raspberry.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.outeseratest.raspberry.domain.model.Movie;
import com.outeseratest.raspberry.domain.model.ProducerInterval;

@Service
public class ProducerService {

    public List<ProducerInterval> calculateIntervals(List<Movie> vencedores) {
        
    	Map<String, List<Integer>> premiosPorProdutor = agruparPremiosPorProdutor(vencedores);
        
        return calcularIntervalosPorProdutor(premiosPorProdutor);
    }

    private Map<String, List<Integer>> agruparPremiosPorProdutor(List<Movie> vencedores) {
        Map<String, List<Integer>> premiosPorProdutor = new HashMap<>();

        for (Movie movie : vencedores) {
            for (String producer : movie.getProducers()) {
                premiosPorProdutor
                    .computeIfAbsent(producer, k -> new ArrayList<>())
                    .add(movie.getYear());
            }
        }

        return premiosPorProdutor;
    }

    private List<ProducerInterval> calcularIntervalosPorProdutor(Map<String, List<Integer>> premiosPorProdutor) {
        List<ProducerInterval> intervalos = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : premiosPorProdutor.entrySet()) {
            String producer = entry.getKey();
            List<Integer> anos = new ArrayList<>(entry.getValue());
            Collections.sort(anos);

            if (anos.size() < 2) continue;

            for (int i = 1; i < anos.size(); i++) {
                int intervalo = anos.get(i) - anos.get(i - 1);
                intervalos.add(new ProducerInterval(producer, intervalo, anos.get(i - 1), anos.get(i)));
            }
        }

        return intervalos;
    }
}


