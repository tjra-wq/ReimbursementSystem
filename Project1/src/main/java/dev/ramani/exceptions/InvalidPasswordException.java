package dev.ramani.exceptions;

public class InvalidPasswordException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
        super(message);
    }
}
