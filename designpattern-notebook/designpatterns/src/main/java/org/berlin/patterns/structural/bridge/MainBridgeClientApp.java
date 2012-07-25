package org.berlin.patterns.structural.bridge;

/**
 * Structural Pattern : Composition of smaller objects to compose larger objects. 
 */


/**
 * The bridge pattern is a design pattern used in software engineering which is meant to 
 * "decouple an abstraction from its implementation so that the two can vary independently".
 * 
 * See:
 * http://en.wikipedia.org/wiki/Bridge_pattern
 */
public class MainBridgeClientApp {

	public static void main(final String [] args) {
		
		System.out.println("Running");
		final XWindowImp windowImpl = new XWindowImp(); 
		final Window window = new Window(windowImpl);
		window.open();
		System.out.println("Done");
		
	}
	
} // End of the class //
