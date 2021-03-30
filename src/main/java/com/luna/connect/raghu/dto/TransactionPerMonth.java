package com.luna.connect.raghu.dto;

public class TransactionPerMonth {
    private long totalTransactions;
    private long debitTransactions;
    private long creditTransactions;
    private double debitTransactionValue;
    private double avgDebitTransactionValue;
    private Double creditTransactionValue;
    private Double avgCreditTransactionValue;

    public TransactionPerMonth() {
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public long getDebitTransactions() {
        return debitTransactions;
    }

    public void setDebitTransactions(long debitTransactions) {
        this.debitTransactions = debitTransactions;
    }

    public double getDebitTransactionValue() {
        return debitTransactionValue;
    }

    public void setDebitTransactionValue(double debitTransactionValue) {
        this.debitTransactionValue = debitTransactionValue;
    }

    public double getAvgDebitTransactionValue() {
        return avgDebitTransactionValue;
    }

    public void setAvgDebitTransactionValue(double avgDebitTransactionValue) {
        this.avgDebitTransactionValue = avgDebitTransactionValue;
    }

    public void setCreditTransactionValue(Double creditTransactionValue) {
        this.creditTransactionValue = creditTransactionValue;
    }

    public void setAvgCreditTransactionValue(Double avgCreditTransactionValue) {
        this.avgCreditTransactionValue = avgCreditTransactionValue;
    }

    public Double getCreditTransactionValue() {
        return creditTransactionValue;
    }

    public Double getAvgCreditTransactionValue() {
        return avgCreditTransactionValue;
    }

    public long getCreditTransactions() {
        return creditTransactions;
    }

    public void setCreditTransactions(long creditTransactions) {
        this.creditTransactions = creditTransactions;
    }
}
