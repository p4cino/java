/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import pl.lodz.uni.bank.transactions.Check;
import pl.lodz.uni.bank.client.Client;
import pl.lodz.uni.bank.transactions.Deposit;
import pl.lodz.uni.bank.transactions.Transaction;
import pl.lodz.uni.bank.transactions.WireOut;



/**
 *
 * @author Wojciech
 */
public class Account {

    private final static Logger logger = Logger.getLogger(Account.class.getName());
    private String number, description;
    private Client client;
    private List transactionHistory;
    private double balance;
    private int depositNumber, checkNumber;

    Logger log = Logger.getLogger("account");
    
    public Account(String number, String description, Client client, double balance) throws Exception {
        log.info("Tworzenie konta o numerze "+number);
        try {
            Long.valueOf(number);
            if (number.length() != 15) {
                throw new AccountNumberException("Numer konta powinien miec 15 znakow");
            }
        } catch (Exception ex) {
            throw new AccountNumberException("Numer konta powinien zawierac same cyfry");
        }
        this.number = number;
        this.description = description;
        this.client = client;
        this.transactionHistory = new ArrayList<Transaction>();
        this.balance = balance;
        this.depositNumber = 1;
        this.checkNumber = 1;
        client.getAccountList().add(this);
        log.info("Konto utworzone");
        
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void doDeposit(Account toAccount, double amount, Date date, String description) {
        log.info("Rejestracja depozytu z konta "+this.getNumber()+ " do konta: "+ toAccount.getNumber());
        Deposit dep = new Deposit(toAccount, amount, date, description, depositNumber++);
        this.balance -= amount;
        toAccount.setBalance(toAccount.getBalance()+amount);
        transactionHistory.add(dep);
        log.info("Rejestracja depozytu zakonczona pozytywnie");
    }

    public void doCheck(Account toAccount, double amount, Date date, String description) {
        log.info("Rejestracja czeku z konta "+toAccount.getNumber()+ " do konta: "+ this.getNumber());
        Check check = new Check(toAccount, amount, date, description, checkNumber++);
        transactionHistory.add(check);
        this.balance+=amount;
        toAccount.setBalance(toAccount.getBalance()-amount);
        log.info("Rejestracja czeku zakonczona pozytywnie");
    }

    public void doWireOut(Account toAccount, String country, String swift, double amount, Date date, String description) {
        log.info("Rejestracja wire-out z konta "+this.getNumber()+ " do konta: "+ toAccount.getNumber());
        WireOut wireOut = new WireOut(toAccount, country, swift, amount, date, description, client.getWireNumber());
        transactionHistory.add(wireOut);
        this.balance-=amount;
        toAccount.setBalance(toAccount.getBalance()+amount);
        log.info("Rejestracja wire-out zakonczona pozytywnie");
    }

    public List getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void showBalance(){
        logger.info("\t\t" + number + " balance: " + balance);
    }
}
