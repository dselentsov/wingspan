package com.wingspan.wingspan.task2.parser;

import java.util.Collection;
import java.util.List;

import com.wingspan.wingspan.task2.model.Transaction;

public interface CsvParser {

    List<Transaction> parse();

    long getUniqueBuySellCombinationsCount(final Collection<Transaction> transactions);

    long moreThan499ExecutionCount(final Collection<Transaction> transactions);

}
