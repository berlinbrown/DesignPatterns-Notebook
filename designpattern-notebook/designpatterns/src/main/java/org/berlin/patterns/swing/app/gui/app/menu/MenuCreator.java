/**
 * Copyright (c) 2006-2010 Berlin Brown (berlin dot brown @gmail.com)  All Rights Reserved
 *
 * http://www.opensource.org/licenses/bsd-license.php

 * All rights reserved.

 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:

 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * * Neither the name of the Botnode.com (Berlin Brown) nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 * 4/4/2012
 * bbrown
 * Contact: Berlin Brown <berlin dot brown at gmail.com>
 */

package org.berlin.patterns.swing.app.gui.app.menu;

/**********************************************************
 * Example Design Pattern Proof of Concept Swing Application 
 * (Input Text Area, Output Area, Scroll bars, menu options) 
 **********************************************************/

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.berlin.patterns.swing.app.gui.IMenuCreator;

/**
 * Default menu selections, File Edit Analyze Configure Help
 *
 * @author berlin
 */
public class MenuCreator implements IMenuCreator {
    
    public JMenuBar createMenu() {
        final JMenuBar menuBar = new JMenuBar();        
        menuBar.add(this.createMenuFile());
        menuBar.add(this.createMenuEdit());
        menuBar.add(this.createMenuTools());
        menuBar.add(this.createMenuConfigure());
        menuBar.add(this.createMenuHelp());        
        return menuBar;
    } // End of the method create menu //
 
    protected JMenu createMenuFile() {
        // With default options: New Project |  Open File | Exit
        final JMenu menuFile = new JMenu("File");
        final JMenuItem menuItemNewProject = new JMenuItem("New Project");
        final JMenuItem menuItemOpenFile = new JMenuItem("Open File");
        final JMenuItem menuItemExt = new JMenuItem("Exit");
        
        menuFile.add(menuItemNewProject);
        menuFile.add(menuItemOpenFile);
        menuFile.add(menuItemExt);        
        return menuFile;
    }
    
    protected JMenu createMenuEdit() {
        // With default options: 
        final JMenu menuEdit = new JMenu("Edit");
        return menuEdit;
    }
    
    protected JMenu createMenuTools() {
        // With default options: 
        final JMenu menuTools = new JMenu("Tools");
        return menuTools;
    }
    
    protected JMenu createMenuConfigure() {
        // With default options: 
        final JMenu menuConfigure = new JMenu("Configure");
        return menuConfigure;
    }
    
    protected JMenu createMenuHelp() {
        // With default options: About
        final JMenu menuHelp = new JMenu("Help");
        final JMenuItem menuItemAbout = new JMenuItem("About");        
        menuHelp.add(menuItemAbout);        
        return menuHelp;
    }
    
} // End of the class //
