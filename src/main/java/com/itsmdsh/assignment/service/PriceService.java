package com.itsmdsh.assignment.service;

import javax.annotation.PostConstruct; // Changed from jakarta to javax
import org.springframework.stereotype.Service;
import java.io.*;
import java.time.LocalTime;
import java.util.*;

@Service
public class PriceService {
    private final List<PriceRecord> records = new ArrayList<>();

    // Standard Java 8 Inner Class instead of a Record
    private static class PriceRecord {
        private final String skuId;
        private final LocalTime start;
        private final LocalTime end;
        private final String price;

        public PriceRecord(String skuId, LocalTime start, LocalTime end, String price) {
            this.skuId = skuId;
            this.start = start;
            this.end = end;
            this.price = price;
        }
        public String getSkuId() { return skuId; }
        public LocalTime getStart() { return start; }
        public LocalTime getEnd() { return end; }
        public String getPrice() { return price; }
    }

    @PostConstruct
    public void init() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("prices.tsv");
        if (is == null) return;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 4) continue;
                records.add(new PriceRecord(parts[0].trim(), 
                    LocalTime.parse(parts[1].trim()), 
                    LocalTime.parse(parts[2].trim()), parts[3].trim()));
            }
        }
    }

    public String findPrice(String skuId, String timeStr) {
        LocalTime searchTime = (timeStr != null) ? LocalTime.parse(timeStr) : LocalTime.now();
        String result = "NOT SET";
        
        for (PriceRecord r : records) {
            if (r.getSkuId().equalsIgnoreCase(skuId)) {
                if (!searchTime.isBefore(r.getStart()) && !searchTime.isAfter(r.getEnd())) {
                    result = r.getPrice();
                }
            }
        }
        return result;
    }
}