/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.bank.bank;

import java.util.ArrayList;
import java.util.logging.Logger;
import pl.lodz.uni.bank.client.Client;

/**
 *
 * @author Wojciech
 */
public class Bank {

    private final String name;
    private final ArrayList<Client> clients;
    private final static Logger logger = Logger.getLogger(Bank.class.getName());

    public Bank(String name) {
        this.name = name;
        clients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addClient(Client c) {
        clients.add(c);
    }

    public void removeClient(Client c) {
        clients.remove(c);
    }

    public void printClients() {
        logger.info("Clients of bank: " + name);
        clients.stream().forEach(c -> {
            c.print();
        });
    }
}
