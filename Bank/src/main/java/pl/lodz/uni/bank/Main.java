/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank;

import pl.lodz.uni.bank.client.Client;
import pl.lodz.uni.bank.account.Account;
import java.util.Date;
import java.util.logging.Logger;
import pl.lodz.uni.bank.bank.Bank;

/**
 *
 * @author Wojciech
 */
public class Main {

    public static final Logger logger = Logger.getLogger("main");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger("BANK");
        logger.info("Program Bank");
        Bank bank = new Bank("PKO");

        Client clientAndrzej = new Client("Andrzej", "Nowak", "Lodz");
        Client clientJanusz = new Client("Janusz", "Kowalski", "Poznan");

        
        Account accountAndrzej = new Account("365784381294301", "Konto prywatne", clientAndrzej, 2000);
        Account accountJanusz = new Account("365812230009236", "Konto prywatne", clientJanusz, 3000);

        bank.addClient(clientJanusz);
        bank.addClient(clientAndrzej);

        accountAndrzej.doCheck(accountJanusz, 200, new Date(), "Opis");
        accountAndrzej.doDeposit(accountJanusz, 321, new Date(), "OPIS 2");
        accountAndrzej.doWireOut(accountJanusz, "KRAJ", "SWITF", 1200., new Date(), "OPIS");
        logger.info("Historia transakcji pierwszego konta");
        accountAndrzej.getTransactionHistory().stream().forEach(x -> logger.info(x.toString()));
        logger.info("Historia transakcji drugiego konta");
        accountJanusz.getTransactionHistory().stream().forEach(x -> logger.info(x.toString()));

        accountJanusz.doCheck(accountAndrzej, 200, new Date(), "Czynsz");
        accountJanusz.doDeposit(accountAndrzej, 200, new Date(), "Zwrot za czynsz");
        accountJanusz.doWireOut(accountAndrzej, "KRAJ2", "SWITF2", 1240., new Date(), "WireOut");
        accountJanusz.doCheck(accountAndrzej, 230, new Date(), "Czynsz");
        logger.info("Historia transakcji drugiego konta");
        accountJanusz.getTransactionHistory().stream().forEach(x -> logger.info(x.toString()));
        
        
        bank.printClients();
    }

}
