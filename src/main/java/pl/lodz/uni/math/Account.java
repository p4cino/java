/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math;

import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Account {
    private String number, description;
    private Client customer;
    private List transactionHistory;
    private double balance;
    private int transactionNumber;

    public Account(String number, String description, Client customer,double balance) throws Exception{
        try{
            Long.valueOf(number);
            if(number.length()!=15){
                throw new AccountNumberException("Numer konta powinien miec 15 znakow");
            }
        }catch(Exception ex){
            throw new AccountNumberException("Numer konta powinien zawierac same cyfry");
        }
        this.number = number;
        this.description = description;
        this.customer = customer;
        this.transactionHistory = new ArrayList<Transaction>();
        this.balance = balance;
        this.transactionNumber = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getCustomer() {
        return customer;
    }

    public void setCustomer(Client customer) {
        this.customer = customer;
    }
    
    public void doTransaction(String countr, String swift, Account account, String description, Date date, Double amount, int transactionNumber, TransactionTypeDictionary transactionType) {
        transactionHistory.add(new Transaction(countr,swift,account,description, date, amount,transactionNumber++,transactionType));
    }
    
    public void doTransaction(Account account, String description, Date date, Double amount, int transactionNumber, TransactionTypeDictionary transactionType) {
        if(transactionType == TransactionTypeDictionary.DEPOSIT){
            this.balance = this.balance + amount;
            double accBalance = account.getBalance();
            accBalance -= amount;
            account.setBalance(accBalance);
        }
        else if(transactionType == TransactionTypeDictionary.CHECKOUT){
            this.balance = this.balance - amount;
            double accBalance = account.getBalance();
            accBalance += amount;
            account.setBalance(accBalance);
        }
         transactionHistory.add(new Transaction(account,description, date, amount,transactionNumber++,transactionType));
    }

    public List getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    
}
