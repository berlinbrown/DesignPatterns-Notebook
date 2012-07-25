package org.berlin.patterns.behavioral.observer.realworld;

public class DetachListener implements IDetachListener {

	@Override
    public void onDetach(Object component) {
		System.out.println("I see that this component is getting detached, handling ...");	    
    }

	@Override
    public void onDestroyListener() {	    
		System.out.println("I see that we are destroying ...");
    }

}
