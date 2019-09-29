package com.masivian.lca.exception;

/**
 * Custom LCA Exception to give information when controlled exception is thrown
 * 
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 *
 */
public class CustomLCAException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new LCA exception.
	 *
	 * @param message the message
	 */
	public CustomLCAException(String message) {
		super(message);
	}

}
