package nl.wijsmullerbros;

/**
 * Exception that is thrown when something in the view system fails.
 * 
 * @author bwijsmuller
 */
public class DisplaySystemRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4415031088997228514L;

	/**
	 * Creates a new {@link DisplaySystemRuntimeException}.
	 * @param message the message to use
	 * @param cause a deeper cause
	 */
	public DisplaySystemRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new {@link DisplaySystemRuntimeException}.
	 * @param message the message to use
	 */
	public DisplaySystemRuntimeException(String message) {
		super(message);
	}
	
}
