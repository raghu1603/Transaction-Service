package com.luna.connect.raghu;

import com.luna.connect.raghu.dto.TransactionPerMonth;

import java.time.Month;
import java.util.Map;

public class PrintTransactionSummary {

    public static void transactionSummary(final Map<Integer, TransactionPerMonth> transactionPerMonthMap) {
        // Print the list objects in tabular format.
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s", "");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s",  Month.of(entry.getKey()).toString() + " |");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s", " Transaction Count |");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s", " " + entry.getValue().getTotalTransactions() + " |");
        System.out.println();
        System.out.printf("%20s", " Credit Count |");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s", " " + entry.getValue().getCreditTransactions() + " |");
        System.out.println();
        System.out.printf("%20s", " Debit Count |");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s", " " + entry.getValue().getDebitTransactions() + " |");
        System.out.println();
        System.out.printf("%20s", " Credit Value |");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s", " " + String.format("%.2f", entry.getValue().getCreditTransactionValue()) + " |");
        System.out.println();
        System.out.printf("%20s", " Debit Value |");
        for (Map.Entry<Integer, TransactionPerMonth> entry : transactionPerMonthMap.entrySet())
            System.out.printf("%11s", " " + String.format("%.2f", entry.getValue().getDebitTransactionValue()) + " |");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
