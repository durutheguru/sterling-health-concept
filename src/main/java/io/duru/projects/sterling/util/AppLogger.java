package io.duru.projects.sterling.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * created by dduru on 02/10/2018
 */
public class AppLogger {

    private static Logger logger = Logger.getLogger(AppLogger.class.getName());


    public static void log(String msg) {
        logger.log(Level.INFO, msg);
    }


}