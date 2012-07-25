package org.berlin.patterns.behavioral.observer.realworld;

public class WicketApplication {
	
	/**
	 * THIS METHOD IS NOT PART OF THE WICKET PUBLIC API. DO NOT CALL IT.
	 */
	public void internalDestroy()
	{
		// destroy detach listener
		final IDetachListener detachListener = getDetachListener();
		if (detachListener != null)
		{
			detachListener.onDestroyListener();
		}
	}
	
	final IDetachListener getDetachListener() {
		return new DetachListener();
	}
	
}
