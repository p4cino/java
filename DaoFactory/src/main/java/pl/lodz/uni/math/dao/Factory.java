/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.dao;

import pl.lodz.uni.math.sources.DaoSource;
import pl.lodz.uni.math.sources.Source;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import pl.lodz.uni.math.sources.Database;
import pl.lodz.uni.math.sources.WebService;
import pl.lodz.uni.math.sources.Xml;

/**
 *
 * @author Wojciech
 */
public class Factory implements DaoFactory {

    private static Factory instance = null;
    private static DaoSource sourceOfData;
    public static final Logger logger = Logger.getLogger(Factory.class.getName());
    Map<Source, DaoSource> sourceMap = new HashMap<Source, DaoSource>();

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    private Factory() {
        sourceMap.put(Source.Database, Database.getInstance());
        sourceMap.put(Source.XML, Xml.getInstance());
        sourceMap.put(Source.WEB_SERVICE, WebService.getInstance());
    }

    public void setSourceOfData(Source source) {
        sourceOfData = sourceMap.get(source);
        logger.info("Setted new soource of data");
    }

    public DaoSource getSource() {
        return sourceOfData;
    }

}