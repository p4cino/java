/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math;

import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wojte
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @Before
    public void setUp() {
        Client ClientAndrzej = new Client("Andrzej", "Zaucha", "Lodz");
        Client ClientJanusz = new Client("Janusz", "Tracz", "Lodz");
    }

    @Test
    public void testDoTransaction_8args() {
        System.out.println("doTransaction");
        String countr = "";
        String swift = "";
        Account account = null;
        String description = "";
        Date date = null;
        Double amount = null;
        int transactionNumber = 0;
        TransactionTypeDictionary transactionType = null;
        Account instance = null;
        instance.doTransaction(countr, swift, account, description, date, amount, transactionNumber, transactionType);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDoTransaction_6args() {
        System.out.println("doTransaction");
        Account account = null;
        String description = "";
        Date date = null;
        Double amount = null;
        int transactionNumber = 0;
        TransactionTypeDictionary transactionType = null;
        Account instance = null;
        instance.doTransaction(account, description, date, amount, transactionNumber, transactionType);
        fail("The test case is a prototype.");
    }

    
}
