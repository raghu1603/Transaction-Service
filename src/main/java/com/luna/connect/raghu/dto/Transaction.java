package com.luna.connect.raghu.dto;

import java.util.Date;

public class Transaction {
    private String id;
    private String currency;
    private String category;
    private Date date;
    private double amount;
    private double balance;
    private String direction;
    private String reference;

    public Transaction() {

    }

    public Transaction(final String accountId, final String currency, final double amount, final String category,
                       final double balance, final Date date, final String direction, final String reference){
        this.id = accountId;
        this.currency = currency;
        this.amount = amount;
        this.category = category;
        this.balance = balance;
        this.date = date;
        this.direction = direction;
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    // consider transaction id is unique
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!id.equals(that.id)) return false;
        return true;
    }

    // consider transaction id is unique
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder( "Transaction{")
                .append("id='" + id + '\'' )
                .append(", currency='" + currency + '\'')
                .append(", category='" + category + '\'' )
                .append(", date=" + date )
                .append(", amount=" + amount )
                .append(", balance=" + balance )
                .append(", direction='" + direction + '\'' )
                .append(", reference='" + reference + '\'' )
                .append('}').toString();
    }
}