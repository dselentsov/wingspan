package com.wingspan.wingspan.task2.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction {

    private final String sellAssetId;

    private final String buyAssetId;

    private final Long amountUSD;

    private final String accountId;
}
