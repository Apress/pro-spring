/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

/**
 * @author robh
 */
public class InvalidCredentialsException extends Exception {

    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 9110367572274561343L;

	/**
     * 
     */
    public InvalidCredentialsException() {
        super();
    }

    /**
     * @param msg The message
     */
    public InvalidCredentialsException(String msg) {
        super(msg);
    }

    /**
     * @param rootCause The cause
     */
    public InvalidCredentialsException(Throwable rootCause) {
        super(rootCause);
    }

    /**
     * @param msg The message
     * @param rootCause The cause
     */
    public InvalidCredentialsException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

}
