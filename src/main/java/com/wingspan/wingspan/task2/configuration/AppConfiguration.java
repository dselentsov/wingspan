package com.wingspan.wingspan.task2.configuration;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

@Configuration
@EnableConfigurationProperties(CsvProperties.class)
public class AppConfiguration {

    @Bean
    public CSVParser csvParser(@Value("${csv.datasource}") String source) throws IOException {
        return new CSVParser(new FileReader(source), CSVFormat.DEFAULT.withHeader());
    }
}

