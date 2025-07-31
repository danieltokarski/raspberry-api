package com.outeseratest.raspberry.infrastructure.util;

import java.util.Arrays;
import java.util.List;

public class ProducerParserUtil {

    public static List<String> parseProducers(String raw) {
        return Arrays.stream(raw.split(",\\s*|\\s+and\\s+"))
                     .map(String::trim)
                     .filter(s -> !s.isEmpty())
                     .toList();
    }

    public static String joinProducers(List<String> producers) {
        return String.join(", ", producers);
    }
}