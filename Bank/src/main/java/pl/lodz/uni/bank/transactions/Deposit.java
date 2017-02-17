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
 * @author Stud
 */
public class Deposit extends Transaction {

    private Account fromAccount;

    public Deposit(Account fromAccount, double amount, Date date, String description, int number) {
        super(amount, date, description, number);
        this.fromAccount = fromAccount;
    }

    @Override
    public String toString() {
        return "Deposit number: " + this.number + " from Account " + fromAccount.getNumber() + " with amount " + super.amount + " date " + super.date + " description: " + description;
   }

}
