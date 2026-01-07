package com.itsmdsh.assignment.service;

import javax.annotation.PostConstruct; // Changed from jakarta to javax
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class ConfigService {
    private final Map<String, Map<String, Object>> configMap = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("config.txt");
        if (is == null) return;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            String currentSection = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("''''")) continue;
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (currentSection != null) {
                        if (key.equalsIgnoreCase("topic")) {
                            configMap.get(currentSection).put(key, Arrays.asList(value.split("\\s*,\\s*")));
                        } else {
                            configMap.get(currentSection).put(key, value);
                        }
                    }
                } else {
                    currentSection = line;
                    configMap.putIfAbsent(currentSection, new HashMap<>());
                }
            }
        }
    }

    public Map<String, Object> getConfig(String section) {
        return configMap.get(section);
    }
}