package com.wingspan.wingspan.task2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("csv")
@Getter
@Setter
public class CsvProperties {

    private String datasource;

    private String assetSold;

    private String assetPurchased;

    private String dollarValue;

    private String accountOwner;
}
