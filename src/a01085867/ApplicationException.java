package a01085867;

/**

 * Project: A00123456Lab3
 * File: ApplicationException.java
 * Copyright 2017 Sam Cirka. All rights reserved.
 */


/**
 * @author Sam Cirka, A00123456
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * Default constructor
	 */
	public ApplicationException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
