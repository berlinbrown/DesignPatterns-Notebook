package org.berlin.patterns.behavioral.visitor.realworld;

/**
 * Generic component visitor interface for component traversals.
 * 
 * @param <T>
 *            The component
 */
public interface IVisitor<T> {
	
	/**
	 * Value to return to continue a traversal.
	 */
	public static final Object CONTINUE_TRAVERSAL = null;

	/**
	 * A generic value to return to continue a traversal, but if the component
	 * is a container, don't visit its children.
	 */
	public static final Object CONTINUE_TRAVERSAL_BUT_DONT_GO_DEEPER = new Object();

	/**
	 * A generic value to return to stop a traversal.
	 */
	public static final Object STOP_TRAVERSAL = new Object();

	/**
	 * Called at each component in a traversal.
	 * 
	 * @param component
	 *            The component
	 * @return CONTINUE_TRAVERSAL (null) if the traversal should continue, or a
	 *         non-null return value for the traversal method if it should stop.
	 *         If no return value is useful, the generic non-null value
	 *         STOP_TRAVERSAL can be used.
	 */
	public Object component(T component);
}