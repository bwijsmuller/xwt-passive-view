package nl.wijsmullerbros;

/**
 * Exception that is thrown when something in the view system fails.
 * @author bwijsmuller
 */
public class DisplaySystemRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4415031088997228514L;

	public DisplaySystemRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DisplaySystemRuntimeException(String message) {
		super(message);
	}
	
}
