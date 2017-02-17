/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math;

import pl.lodz.uni.math.dao.Factory;
import pl.lodz.uni.math.sources.Source;

/**
 *
 * @author Wojciech
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Factory df = Factory.getInstance();
        
        df.setSourceOfData(Source.XML);
        df.getSource().selectAllUsers().size();
        df.getSource().selectUserById(1);
        
        Factory df2 = Factory.getInstance();
        
        df2.setSourceOfData(Source.XML);
        df2.getSource().selectAllUsers().size();
        df2.getSource().selectUserById(2);
        
        
        df.setSourceOfData(Source.Database);
        df.getSource().selectAllUsers().size();
        df.getSource().selectUserById(1);
        
        Factory df3 = Factory.getInstance();
        
        df3.setSourceOfData(Source.Database);
        df3.getSource().selectAllUsers().size();
        df3.getSource().selectUserById(2);
        
        
        df.setSourceOfData(Source.WEB_SERVICE);
        df.getSource().selectAllUsers().size();
        df.getSource().selectUserById(1);
    }
    
}