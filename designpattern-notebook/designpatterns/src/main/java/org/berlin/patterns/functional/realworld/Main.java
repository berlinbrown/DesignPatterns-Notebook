package org.berlin.patterns.functional.realworld;

public class Main {

	public void doSomething(final String info, final AsyncCallback callback) {
		if (callback == null) {
			throw new IllegalArgumentException("Invalid Argument Callback");
		}
		System.out.println("Entering doSomething");
		final boolean passedEvent = true;
		if (passedEvent) {
			callback.onSuccess("passed");
		}
		System.out.println("Exiting doSomething");
	} // End of the method //
	
	public void doSomethingAndFail(final String info, final AsyncCallback callback) {
		if (callback == null) {
			throw new IllegalArgumentException("Invalid Argument Callback");
		}
		System.out.println("Entering doSomething");
		final boolean failedEvent = true;
		if (failedEvent) {
			callback.onFailure(new RuntimeException("Invalid Callback Error"));
		}
		System.out.println("Exiting doSomething");
	} // End of the method //
	
	public static void main(final String [] args) {
		System.out.println("Running");
		final Main m = new Main();
		final AsyncCallback callback = new AsyncCallback() {
			@Override
            public void onFailure(final Throwable caught) {	         
	            System.out.println("We failed");
	            caught.printStackTrace();
            }
			@Override
            public void onSuccess(final Object result) {
				System.out.println("We passed : " + result);
            }			
		};
		m.doSomething("DoSomething", callback);
		m.doSomethingAndFail("DoSomethingAndFail", callback);
		System.out.println("Done");
	} // End of the method //
	
} // End of the class 
