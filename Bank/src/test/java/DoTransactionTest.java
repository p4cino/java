/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.lodz.uni.bank.account.Account;
import pl.lodz.uni.bank.client.Client;

/**
 *
 * @author Wojciech
 */
public class DoTransactionTest {

    Client first, second;
    Account accFirst, accSecond;
    double firstAmount, secondAmount;

    public DoTransactionTest() {
    }

    @Before
    public void setUp() throws Exception {
        first = new Client("Andrzej", "Testowy", "Lodz 1234");
        second = new Client("Janusz", "Testowy", "Lodz 1234");
        firstAmount = 2500.;
        secondAmount = 1500.;
        
        assertNotNull(first);
        assertNotNull(second);
        accFirst = new Account("123456789113270", "Konto prywatne", first, firstAmount);
        accSecond = new Account("123456789177101", "Konto prywatne", second, secondAmount);
    }

    @Test
    public void doCheck() {
        double checkAmount = 400.;
        double myPi = 22.0d / 7.0d;
        accFirst.doCheck(accSecond, checkAmount, new Date(), "Pierwszy czek");
        assertEquals(accFirst.getBalance(), firstAmount + checkAmount, myPi);
        assertEquals(accSecond.getBalance(), secondAmount - checkAmount, 1.0);
        firstAmount += checkAmount;
        secondAmount -= checkAmount;
        assertNotNull(accFirst.getTransactionHistory().get(0));
    }

    @Test
    public void doDeposit() {
        double depositAmount = 200.;
        double myPi = 22.0d / 7.0d;
        accFirst.doDeposit(accSecond, depositAmount, new Date(), "Pierwszy czek");
        assertEquals(accFirst.getBalance(), firstAmount - depositAmount, myPi);
        assertEquals(accSecond.getBalance(), secondAmount + depositAmount, myPi);
        firstAmount -= depositAmount;
        secondAmount += depositAmount;
        assertNotNull(accFirst.getTransactionHistory().get(0));
    }

    @Test
    public void doWire() {
        double checkAmount = 400.;
        double myPi = 22.0d / 7.0d;
        accFirst.doWireOut(accSecond, "Poland", "SWIFT", checkAmount, new Date(), "Pierwszy czek");
        assertEquals(accFirst.getBalance(), firstAmount - checkAmount, myPi);
        assertEquals(accSecond.getBalance(), secondAmount + checkAmount, 1.0);
        assertNotNull(accFirst.getTransactionHistory().get(0));
    }

}
