package com.reprezen.kaizen.oasparser.val;

public class ValidationContext implements AutoCloseable {

	static ThreadLocal<ValidationContext> threadInstance = new ThreadLocal<ValidationContext>();

	private ValidationResults validationResults;
	private VisitedObjectRegistry visitedObjectRegistry;

	public ValidationContext() {
		ValidationContext context = threadInstance.get();
		if (context != null) {
			throw new IllegalStateException();
		}
		this.validationResults = new ValidationResults();
		this.visitedObjectRegistry = new VisitedObjectRegistry();

		threadInstance.set(this);
	}

	public static ValidationContext open() {
		return new ValidationContext();
	}

	public static ValidationContext get() {
		return threadInstance.get();
	}

	public static ValidationResults getValidationResults() {
		ValidationContext context = get();
		if (context != null) {
			return context.validationResults;
		} else {
			throw new IllegalStateException();
		}
	}

	public static boolean visitIfUnvisited(Object o) {
		ValidationContext context = get();
		if (context != null) {
			return context.visitedObjectRegistry.visitIfUnvisited(o);
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void close() {
		threadInstance.remove();
	}
}