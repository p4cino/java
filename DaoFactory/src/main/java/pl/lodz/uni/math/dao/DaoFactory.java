/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.dao;

import pl.lodz.uni.math.sources.DaoSource;
import pl.lodz.uni.math.sources.Source;

/**
 *
 * @author Wojciech
 */
public interface DaoFactory {

    public void setSourceOfData(Source source);

    public DaoSource getSource();

}
