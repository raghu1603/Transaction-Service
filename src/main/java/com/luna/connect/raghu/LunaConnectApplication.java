package com.luna.connect.raghu;

import com.luna.connect.raghu.dto.Transaction;
import com.luna.connect.raghu.dto.TransactionPerMonth;
import com.luna.connect.raghu.exception.MyErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Month;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.*;

@SpringBootApplication
public class LunaConnectApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LunaConnectApplication.class);

    public static void main(final String[] args) {
        SpringApplication.run(LunaConnectApplication.class);
    }

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(final String... args) {
        final RestTemplate restTemplate = new RestTemplate();
        final String BASE_URL = "https://5c937fdb4dca5d0014ad825b.mockapi.io/data";

        restTemplate.setErrorHandler(new MyErrorHandler());
        ResponseEntity<Transaction[]> transactionEntities = restTemplate
                .getForEntity(BASE_URL, Transaction[].class);
        final List<Transaction> transactionList = new ArrayList<>();
        for (final Transaction object: transactionEntities.getBody()) {
            transactionList.add(object);
        }
        log.info("Total number of records: " +transactionList.size());
        System.out.println("Total number of records: " +transactionList.size());
        System.out.println();
        //Sum the final total transaction amount
        Map<Integer, List<Transaction>> transactionPerMonth = new HashMap<>();
        for (Month month: Month.values()) {
            List<Transaction> transactions = transactionList
                .stream()
                .filter(tran -> tran.getDate().getMonth() == month.getValue())
                .collect(toList());
            transactionPerMonth.put(month.getValue(), transactions);
        }
        log.info("Total Summary");
        log.info("------------------------------------------------------------");
        final Map<Integer, TransactionPerMonth> transactionPerMonthMap = new HashMap<>();
        for (final Map.Entry<Integer, List<Transaction>> entry : transactionPerMonth.entrySet()) {
            log.info("Transaction details for {} month", Month.of(entry.getKey()).toString());
            final List<Transaction> perMonthTransactions =  entry.getValue();
            log.info("Total Transaction: " + perMonthTransactions.size());
            TransactionPerMonth transactionsPerMonth = new TransactionPerMonth();
            transactionsPerMonth.setTotalTransactions(perMonthTransactions.size());
            Map<String, Double> transactionTypeToTotal =
                    perMonthTransactions.stream().collect(groupingBy(Transaction::getDirection,
                            summingDouble(Transaction::getAmount)));
            transactionTypeToTotal.forEach((k, v) -> log.info(("Transaction Type : "+k + ": Total transaction amount- " + v)));
            transactionsPerMonth.setDebitTransactionValue(transactionTypeToTotal.get("DEBIT") == null? 0:transactionTypeToTotal.get("DEBIT"));
            transactionsPerMonth.setCreditTransactionValue(transactionTypeToTotal.get("CREDIT")==null?0:transactionTypeToTotal.get("CREDIT"));
            Map<String, Double> transactionTypeToAverage =
                    perMonthTransactions.stream().collect(groupingBy(Transaction::getDirection,
                            averagingDouble(Transaction::getAmount)));
            transactionTypeToAverage.forEach((k, v) -> log.info(("Transaction Type : "+k + ": Average transaction amount- " + v)));
            transactionsPerMonth.setAvgDebitTransactionValue(transactionTypeToAverage.get("DEBIT") == null? 0 : transactionTypeToAverage.get("DEBIT"));
            transactionsPerMonth.setAvgCreditTransactionValue(transactionTypeToAverage.get("CREDIT")==null?0 : transactionTypeToAverage.get("CREDIT"));
            Map<String, Long> transactionTypeToSum =
                    perMonthTransactions.stream().collect(groupingBy(Transaction::getDirection, counting()));
            transactionTypeToSum.forEach((k, v) -> log.info(("Transaction Type : "+k + ": Total transactions- " + v)));
            transactionsPerMonth.setDebitTransactions(transactionTypeToSum.get("DEBIT") == null?0: transactionTypeToSum.get("DEBIT"));
            transactionsPerMonth.setCreditTransactions(transactionTypeToSum.get("CREDIT") == null?0: transactionTypeToSum.get("CREDIT"));
            transactionPerMonthMap.put(entry.getKey(), transactionsPerMonth);
        }
        log.info("------------------------------------------------------------");
        Map sorted = transactionPerMonthMap
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        PrintTransactionSummary.transactionSummary(sorted);
    }

}
