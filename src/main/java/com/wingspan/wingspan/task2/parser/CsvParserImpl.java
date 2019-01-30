package com.wingspan.wingspan.task2.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wingspan.wingspan.task2.configuration.CsvProperties;
import com.wingspan.wingspan.task2.model.Transaction;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Component
public class CsvParserImpl implements CsvParser {

    private final CSVParser parser;

    private final CsvProperties properties;

    @Autowired
    public CsvParserImpl(CSVParser parser, CsvProperties properties) {
        this.parser = parser;
        this.properties = properties;
    }


    @Override
    public List<Transaction> parse() {
        List<Transaction> transactions = new ArrayList<>();

        for (CSVRecord record : parser) {
            transactions.add(new Transaction(record.get(properties.getAssetSold()),
                record.get(properties.getAssetPurchased()),
                Long.valueOf(record.get(properties.getDollarValue())),
                record.get(properties.getAccountOwner())));
        }

        return transactions;
    }

    @Override
    public long getUniqueBuySellCombinationsCount(final Collection<Transaction> transactions) {
        return transactions
            .stream()
            .distinct()
            .count();
    }

    @Override
    public long moreThan499ExecutionCount(final Collection<Transaction> transactions) {
        final HashMap<String, Integer> transactionsMap = new HashMap<>();

        for (Transaction transaction : transactions) {
            String account = transaction.getAccountId();

            if (transactionsMap.containsKey(account)) {
                Integer count = transactionsMap.get(account);
                transactionsMap.put(account, ++count);
            } else {
                transactionsMap.put(account, 1);
            }
        }

        return transactionsMap
            .entrySet()
            .stream()
            .filter(p -> p.getValue() >= 500)
            .count();
    }
}
