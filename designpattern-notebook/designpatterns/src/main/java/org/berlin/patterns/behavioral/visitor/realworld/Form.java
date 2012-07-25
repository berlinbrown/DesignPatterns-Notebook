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


/**
 * Base class for forms. To implement a form, subclass this class, add
 * FormComponents (such as CheckBoxes, ListChoices or TextFields) to the form.
 * You can nest multiple IFormSubmittingComponents if you want to vary submit
 * behavior. However, it is not necessary to use any of Wicket's classes (such
 * as Button or SubmitLink), just putting e.g. &lt;input type="submit"
 * value="go"&gt; suffices.
 * <p>
 * By default, the processing of a form works like this:
 * <li>The submitting component is looked up. An submitting
 * IFormSubmittingComponent (such as a button) is nested in this form (is a
 * child component) and was clicked by the user. If an IFormSubmittingComponent
 * was found, and it has the defaultFormProcessing field set to false (default
 * is true), it's onSubmit method will be called right away, thus no validition
 * is done, and things like updating form component models that would normally
 * be done are skipped. In that respect, nesting an IFormSubmittingComponent
 * with the defaultFormProcessing field set to false has the same effect as
 * nesting a normal link. If you want you can call validate() to execute form
 * validation, hasError() to find out whether validate() resulted in validation
 * errors, and updateFormComponentModels() to update the models of nested form
 * components.</li>
 * <li>When no submitting IFormSubmittingComponent with defaultFormProcessing
 * set to false was found, this form is processed (method process()). Now, two
 * possible paths exist:
 * <ul>
 * <li>Form validation failed. All nested form components will be marked
 * invalid, and onError() is called to allow clients to provide custom error
 * handling code.</li>
 * <li>Form validation succeeded. The nested components will be asked to update
 * their models and persist their data is applicable. After that, method
 * delegateSubmit with optionally the submitting IFormSubmittingComponent is
 * called. The default when there is a submitting IFormSubmittingComponent is to
 * first call onSubmit on that Component, and after that call onSubmit on this
 * form. Clients may override delegateSubmit if they want different behavior.</li>
 * </ul>
 * </li>
 * </li>
 * </p>
 * 
 * Form for handling (file) uploads with multipart requests is supported by
 * calling setMultiPart(true) ( although wicket will try to automatically detect
 * this for you ). Use this with
 * {@link org.apache.wicket.markup.html.form.upload.FileUploadField} components.
 * You can attach multiple FileUploadField components for multiple file uploads.
 * <p>
 * In case of an upload error two resource keys are available to specify error
 * messages: uploadTooLarge and uploadFailed
 * 
 * ie in [page].properties
 * 
 * [form-id].uploadTooLarge=You have uploaded a file that is over the allowed
 * limit of 2Mb
 * 
 * <p>
 * If you want to have multiple IFormSubmittingComponents which submit the same
 * form, simply put two or more IFormSubmittingComponents somewhere in the
 * hierarchy of components that are children of the form.
 * </p>
 * <p>
 * To get form components to persist their values for users via cookies, simply
 * call setPersistent(true) on each component.
 * </p>
 * <p>
 * Forms can be nested. You can put a form in another form. Since HTML doesn't
 * allow nested &lt;form&gt; tags, the inner forms will be rendered using the
 * &lt;div&gt; tag. You have to submit the inner forms using explicit components
 * (like Button or SubmitLink), you can't rely on implicit submit behavior (by
 * using just &lt;input type="submit"&gt; that is not attached to a component).
 * </p>
 * <p>
 * When a nested form is submitted, the user entered values in outer (parent)
 * forms are preserved and only the fields in the submitted form are validated.
 * </b>
 * 
 * @author Jonathan Locke
 * @author Juergen Donnerstag
 * @author Eelco Hillenius
 * @author Cameron Braid
 * @author Johan Compagner
 * @author Igor Vaynberg (ivaynberg)
 * @author David Leangen
 * 
 * @param <T>
 *            The model object type
 */
public class Form<T> extends MarkupContainer {
	
	private static final String HIDDEN_DIV_START = "<div style=\"width:0px;height:0px;position:absolute;left:-100px;top:-100px;overflow:hidden\">";

	/**
	 * Visitor used for validation
	 * 
	 * @author Igor Vaynberg (ivaynberg)
	 */
	public static class ValidationVisitor implements IVisitor<IFormVisitorParticipant> {
		/**
		 * @see org.apache.wicket.markup.html.form.FormComponent.IVisitor#formComponent(org.apache.wicket.markup.html.form.IFormVisitorParticipant)
		 */
		public Object component(IFormVisitorParticipant component) {
			final IFormVisitorParticipant formComponent = (IFormVisitorParticipant) component;
			formComponent.processChildren();
			return 1;
		}

	}

}
