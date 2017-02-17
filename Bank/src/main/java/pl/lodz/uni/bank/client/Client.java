/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank.client;

import java.util.ArrayList;
import java.util.logging.Logger;
import pl.lodz.uni.bank.account.Account;

/**
 *
 * @author Wojciech
 */
public class Client {

    private final static Logger logger = Logger.getLogger(Client.class.getName());
    private String firstName, lastName, addres;
    private int wireNumber;
    private ArrayList<Account> accountList;

    public Client(String firstName, String lastName, String addres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addres = addres;
        this.wireNumber = 1;
        accountList = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getWireNumber() {
        return wireNumber;
    }

    public void setWireNumber(int wireNumber) {
        this.wireNumber = wireNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void print() {
        logger.info("\tCustomer: " + firstName + " " + lastName + ", " + addres);
        accountList.stream().forEach(a -> {
            a.showBalance();
        });
    }
}