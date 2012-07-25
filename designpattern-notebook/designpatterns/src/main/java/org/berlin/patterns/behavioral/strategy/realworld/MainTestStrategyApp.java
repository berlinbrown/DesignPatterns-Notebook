package org.berlin.patterns.behavioral.strategy.realworld;

public class MainTestStrategyApp {

	public static void main(final String [] args) {
		System.out.println("Running");
		final IAuthorizationStrategy activeStrategy = IAuthorizationStrategy.ALLOW_ALL;
		final boolean hasAction = activeStrategy.isActionAuthorized("Component1", "Action1");
		System.out.println("hasAction=" + hasAction + " activeStrategy.isActionAuthorized");
		System.out.println("Done");
	}

}
