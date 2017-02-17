/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank.transactions;

import java.util.Date;

/**
 *
 * @author Wojciech
 */
public abstract class Transaction {

    protected double amount;
    protected Date date;
    protected String description;
    protected int number;

    public Transaction(double amount, Date date, String description, int number) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.number = number;
    }

}
