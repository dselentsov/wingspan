package com.wingspan.wingspan;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.wingspan.wingspan.task2.model.Transaction;
import com.wingspan.wingspan.task2.parser.CsvParserImpl;
import org.apache.commons.csv.CSVParser;

@SpringBootApplication
public class WingspanApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WingspanApplication.class, args);

        CsvParserImpl parser = context.getBean(CsvParserImpl.class);
        List<Transaction> transactions = parser.parse();
        System.out.println("Unique buy/sell combinations: " + parser.getUniqueBuySellCombinationsCount(transactions));
        System.out.println("Accounts with 500 or more transactions : " + parser.moreThan499ExecutionCount(transactions));
    }

}

