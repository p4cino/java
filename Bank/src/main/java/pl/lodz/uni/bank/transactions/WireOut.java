/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank.transactions;

import pl.lodz.uni.bank.account.Account;
import java.util.Date;

/**
 *
 * @author Wojciech
 */
public class WireOut extends Transaction {

    private String country;
    private String swift;
    private Account toAccount;

    public WireOut(Account toAccount, String country, String swift, double amount, Date date, String description, int number) {
        super(amount, date, description, number);
        this.country = country;
        this.swift = swift;
        this.toAccount = toAccount;
    }

    @Override
    public String toString() {
        return "Deposit number: " + this.number + " to Account " + toAccount.getNumber() + " with amount "
                + super.amount + " date " + super.date + " description: " + description + " country " + this.country + " swift " + this.swift;
    }

    public int getNumber() {
        return number;
    }

}
