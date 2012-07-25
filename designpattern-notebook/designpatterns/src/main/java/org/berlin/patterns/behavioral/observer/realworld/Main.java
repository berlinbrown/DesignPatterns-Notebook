package org.berlin.patterns.behavioral.observer.realworld;

public class Main {

	public static void main(final String [] args) {
		System.out.println("Running");
		final WicketApplication app = new WicketApplication();
		app.internalDestroy();
		System.out.println("Done");		
	}
	
}
