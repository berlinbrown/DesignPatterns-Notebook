package org.berlin.patterns.structural.bridge;

/**
 * The bridge pattern is a design pattern used in software engineering which is meant to "decouple an abstraction from its implementation so that the two can vary independently".
 * 
 * See:
 * http://en.wikipedia.org/wiki/Bridge_pattern
 */
public class Window {

	private final IWindowCoreImplementor windowimp;
	
	public Window(final IWindowCoreImplementor windowimp) {
		this.windowimp = windowimp;
	}
	
	public void open() {
		this.windowimp.toString();
	}
	
	public void close() {
		this.windowimp.toString();
	}
	
}
