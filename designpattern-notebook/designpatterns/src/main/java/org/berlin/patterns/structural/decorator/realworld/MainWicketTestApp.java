package org.berlin.patterns.structural.decorator.realworld;

public class MainWicketTestApp {

	public static void main(final String[] args) {

		final MainWicketTestApp hasDecorator = new MainWicketTestApp();
		final CharSequence result = hasDecorator.generateCallbackScript("partialcall();");
		System.out.println("HasResult : " + result);
	}

	protected CharSequence generateCallbackScript(final CharSequence partialCall) {
		final CharSequence onSuccessScript = getSuccessScript();
		final CharSequence onFailureScript = getFailureScript();
		final CharSequence precondition = getPreconditionScript();
		final IAjaxCallDecoratorWICKET decorator = getAjaxCallDecorator();
		CharSequence success = (onSuccessScript == null) ? "" : onSuccessScript;
		CharSequence failure = (onFailureScript == null) ? "" : onFailureScript;		
		success = decorator.decorateScript(success);
		return success;
	}

	public IAjaxCallDecoratorWICKET getAjaxCallDecorator() {
		final IAjaxCallDecoratorWICKET base = new IAjaxCallDecoratorWICKET() {
			@Override
			public CharSequence decorateScript(CharSequence script) {
				return "decorate1()";
			}

			@Override
			public CharSequence decorateOnSuccessScript(CharSequence script) {
				return "decorate1Success()";
			}

			@Override
			public CharSequence decorateOnFailureScript(CharSequence script) {
				return "decorate1Failure()";
			}
		};
		return new AjaxCallThrottlingDecorator(base, "id", 100);
	}

	public CharSequence getSuccessScript() {
		return "javascript: success();";
	}

	public CharSequence getFailureScript() {
		return "javascript: failure();";
	}

	public CharSequence getPreconditionScript() {
		return "javascript: precondition();";
	}

} // End of the class //
