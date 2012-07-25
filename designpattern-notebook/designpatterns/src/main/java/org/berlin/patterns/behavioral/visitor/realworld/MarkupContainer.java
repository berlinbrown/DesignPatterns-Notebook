/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.berlin.patterns.behavioral.visitor.realworld;

import java.awt.Component;
import java.util.AbstractList;

/**
 * A MarkupContainer holds a map of child components.
 * <ul>
 * <li><b>Children </b>- Children can be added by calling the add() method, and
 * they can be looked up using a dotted path. For example, if a container called
 * "a" held a nested container "b" which held a nested component "c", then
 * a.get("b:c") would return the Component with id "c". The number of children
 * in a MarkupContainer can be determined by calling size(), and the whole
 * hierarchy of children held by a MarkupContainer can be traversed by calling
 * visitChildren(), passing in an implementation of Component.IVisitor.
 * 
 * <li><b>Markup Rendering </b>- A MarkupContainer also holds/references
 * associated markup which is used to render the container. As the markup stream
 * for a container is rendered, component references in the markup are resolved
 * by using the container to look up Components in the container's component map
 * by id. Each component referenced by the markup stream is given an opportunity
 * to render itself using the markup stream.
 * <p>
 * Components may alter their referring tag, replace the tag's body or insert
 * markup after the tag. But components cannot remove tags from the markup
 * stream. This is an important guarantee because graphic designers may be
 * setting attributes on component tags that affect visual presentation.
 * <p>
 * The type of markup held in a given container subclass can be determined by
 * calling getMarkupType(). Markup is accessed via a MarkupStream object which
 * allows a component to traverse ComponentTag and RawMarkup MarkupElements
 * while rendering a response. Markup in the stream may be HTML or some other
 * kind of markup, such as VXML, as determined by the specific container
 * subclass.
 * <p>
 * A markup stream may be directly associated with a container via
 * setMarkupStream. However, a container which does not have a markup stream
 * (its getMarkupStream() returns null) may inherit a markup stream from a
 * container above it in the component hierarchy. The findMarkupStream() method
 * will locate the first container at or above this container which has a markup
 * stream.
 * <p>
 * All Page containers set a markup stream before rendering by calling the
 * method getAssociatedMarkupStream() to load the markup associated with the
 * page. Since Page is at the top of the container hierarchy, it is guaranteed
 * that findMarkupStream will always return a valid markup stream.
 * 
 * @see MarkupStream
 * @author Jonathan Locke
 * 
 */
public abstract class MarkupContainer {
	private static final long serialVersionUID = 1L;

	/** List of children or single child */
	private Object children;

	/**
	 * Traverses all child components of the given class in this container,
	 * calling the visitor's visit method at each one.
	 * 
	 * Make sure that if you give a type S that the clazz parameter will only
	 * resolve to those types. Else a class cast exception will occur.
	 * 
	 * @param <S>
	 *            The type that goes into the Visitor.component() method.
	 * 
	 * @param clazz
	 *            The class of child to visit, or null to visit all children
	 * @param visitor
	 *            The visitor to call back to
	 * @return The return value from a visitor which halted the traversal, or
	 *         null if the entire traversal occurred
	 */
	public final <S extends Component> Object visitChildren(final Class<?> clazz, final IVisitor<S> visitor)

	{
		if (visitor == null) {
			throw new IllegalArgumentException("argument visitor may not be null");
		}

		// Iterate through children of this container
		for (int i = 0; i < 1; i++) {
			// Get next child component
			final Component child = children_get(i);
			Object value = null;

			// Is the child of the correct class (or was no class specified)?
			if (clazz == null || clazz.isInstance(child)) {
				// Call visitor
				@SuppressWarnings("unchecked")
				S s = (S) child;
				value = visitor.component(s);

				// If visitor returns a non-null value, it halts the traversal
				if ((value != IVisitor.CONTINUE_TRAVERSAL) && (value != IVisitor.CONTINUE_TRAVERSAL_BUT_DONT_GO_DEEPER)) {
					return value;
				}
			}

			// If child is a container
			// value = child.visitChildren(clazz, visitor);
			return value;
		}

		return null;
	}

	/**
	 * Traverses all child components in this container, calling the visitor's
	 * visit method at each one.
	 * 
	 * @param visitor
	 *            The visitor to call back to
	 * @return The return value from a visitor which halted the traversal, or
	 *         null if the entire traversal occurred
	 */
	public final Object visitChildren(final IVisitor<Component> visitor) {
		return visitChildren(null, visitor);
	}

	/**
	 * @param child
	 *            Child to add
	 */
	private final void children_add(final Component child) {
		if (children == null) {
			children = child;
		} else {
			if (!(children instanceof ChildList)) {
				// Save new children
				children = new ChildList(children);
			}
			((ChildList) children).add(child);
		}
	}

	/**
	 * Returns child component at the specified index
	 * 
	 * @param index
	 * @throws ArrayIndexOutOfBoundsException
	 * @return child component at the specified index
	 */
	public final Component get(int index) {
		return children_get(index);
	}

	/**
	 * 
	 * @param index
	 * @return The child component
	 */
	private final Component children_get(int index) {
		// return (Component) children_get(index, true);
		return null;
	}

	/**
	 * 
	 */
	private static class ChildList extends AbstractList<Object> {
		private static final long serialVersionUID = -7861580911447631127L;
		private int size;
		private Object[] childs;

		/**
		 * Construct.
		 * 
		 * @param children
		 */
		public ChildList(Object children) {
			if (children instanceof Object[]) {
				childs = (Object[]) children;
				size = childs.length;
			} else {
				childs = new Object[3];
				add(children);
			}
		}

		@Override
		public Object get(int index) {
			return childs[index];
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean add(Object o) {
			ensureCapacity(size + 1);
			childs[size++] = o;
			return true;
		}

		@Override
		public void add(int index, Object element) {
			if (index > size || index < 0) {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			}

			ensureCapacity(size + 1);
			System.arraycopy(childs, index, childs, index + 1, size - index);
			childs[index] = element;
			size++;
		}

		@Override
		public Object set(int index, Object element) {
			if (index >= size) {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			}

			Object oldValue = childs[index];
			childs[index] = element;
			return oldValue;
		}

		@Override
		public Object remove(int index) {
			if (index >= size) {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			}

			Object oldValue = childs[index];

			int numMoved = size - index - 1;
			if (numMoved > 0) {
				System.arraycopy(childs, index + 1, childs, index, numMoved);
			}
			childs[--size] = null; // Let gc do its work

			return oldValue;
		}

		/**
		 * @param minCapacity
		 */
		public void ensureCapacity(int minCapacity) {
			int oldCapacity = childs.length;
			if (minCapacity > oldCapacity) {
				Object oldData[] = childs;
				int newCapacity = oldCapacity * 2;
				if (newCapacity < minCapacity) {
					newCapacity = minCapacity;
				}
				childs = new Object[newCapacity];
				System.arraycopy(oldData, 0, childs, 0, size);
			}
		}
	}

}
