/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math;

import java.util.Date;

public class Transaction {

    private String countr, swift;
    private final Account account;
    private final String description;
    private final Date date;
    private final Double amount;
    private final int transactionNumber;
    private final TransactionTypeDictionary transactionType;

    public Transaction(String countr, String swift, Account account, String description, Date date, Double amount, int transactionNumber, TransactionTypeDictionary transactionType) {
        this.countr = countr;
        this.swift = swift;
        this.account = account;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
    }

    public Transaction(Account account, String description, Date date, Double amount, int transactionNumber, TransactionTypeDictionary transactionType) {
        this.account = account;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" + "account=" + account + ", description=" + description + ", date=" + date + ", amount=" + amount + ", transactionNumber=" + transactionNumber + ", transactionType=" + transactionType + '}';
    }

    
}
