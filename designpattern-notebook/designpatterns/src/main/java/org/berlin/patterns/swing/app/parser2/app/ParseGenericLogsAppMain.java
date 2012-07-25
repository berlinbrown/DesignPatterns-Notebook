/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.berlin.patterns.swing.app.parser2.app;

/**********************************************************
 * Example Design Pattern Proof of Concept Swing Application 
 * (Input Text Area, Output Area, Scroll bars, menu options) 
 **********************************************************/

import org.berlin.patterns.swing.app.gui.app.BasicApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for payment log parser gui.
 * @author berlin
 */
public class ParseGenericLogsAppMain {    
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseGenericLogsAppMain.class);
  
    /**     
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LOGGER.info(">>>");
        LOGGER.info(">>> Loading basic UI Log Parser application");    
        LOGGER.info(">>>");   
        LOGGER.info(" *****  NOTE-1 : DON'T FORGET TO CHECK YOUR : 'perLine.dateTimeStart' or parse logic may not happen will not render");
        LOGGER.info(" *****  NOTE-2 : The DOWNLOADS are a great way to quickly download log files");                
        try {                    
            final BasicApp app = new BasicApp();
            app.createApplication();                
        } finally {
            LOGGER.info(" *****  Done with init application:");
        }
    } // End of the method //
} // End of the class //
