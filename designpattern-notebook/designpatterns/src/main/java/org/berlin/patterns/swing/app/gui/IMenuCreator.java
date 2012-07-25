/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.berlin.patterns.swing.app.gui;

/**********************************************************
 * Example Design Pattern Proof of Concept Swing Application 
 * (Input Text Area, Output Area, Scroll bars, menu options) 
 **********************************************************/

import javax.swing.JMenuBar;

/**
 * @author berlin
 */
public interface IMenuCreator {
    JMenuBar createMenu();
} 