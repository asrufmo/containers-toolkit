package com.testing.containers.utils;

import java.util.Map;
import java.util.stream.Collectors;

public class EnvConverter {
    public static Map<String, String> convertToSpringEnv(Map<String, String> props) {
        return props.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> "SPRING_" + e.getKey().toUpperCase().replace(".", "_"),
                        Map.Entry::getValue
                ));
    }
}
