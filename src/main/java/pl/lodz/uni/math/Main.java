/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math;

import java.util.Date;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {     
       Logger logger = Logger.getLogger("BANK");
       logger.info("Program Bank");
       
       Client clientAndrzej = new Client("Anrzej", "Andrzejowski", "Lodz");
       Client clientJanusz = new Client("Janusz","Tracz", "Lodz");
       
       Account accAdam = new Account("123456789111110", "Konto prywatne", clientAndrzej, 2000);
       Account accJan = new Account("123456789111101", "Konto prywatne", clientJanusz, 3000);
       
       accAdam.doTransaction(accJan, "Przelew zwykły",new Date(), 16.12, 0, TransactionTypeDictionary.DEPOSIT);
       accAdam.doTransaction(accJan, "Przelew zwykły",new Date(), 20., 0, TransactionTypeDictionary.CHECKOUT);
       accAdam.getTransactionHistory().stream().forEach(x -> logger.info(x.toString()));
       logger.info(String.valueOf(accAdam.getBalance()));
       
//       StringBuffer sb = new StringBuffer("Test ");
//       sb.append("Java");
//       logger.info(sb.toString());
//       
//       sb.reverse();
//       logger.info(sb.toString());
//       
//       sb = new StringBuffer("Test");
//       
//       sb.trimToSize();
//       
//       sb.replace(1, 3,"");
//       logger.info(sb.toString());
//       
//       sb.setLength(4);
//       logger.info(sb.toString());
//       
//       sb = new StringBuffer("Test");
//       
//       sb.hashCode();
//       logger.info(sb.toString());
//       
//       sb = new StringBuffer("Test");
//       sb.deleteCharAt(1);
//       logger.info(sb.toString());
//       
//       sb.substring(1);
//       logger.info(sb.toString());
       
    }
    
}
