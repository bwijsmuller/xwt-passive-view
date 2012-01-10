package nl.wijsmullerbros;

/**
 * @author bwijsmuller
 */
public class Assert {
	
	private Assert() {
		//hidden
	}
	
	public static void notNull(Object val, String msg) {
		if (val == null) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void state(boolean valid, String msg) {
		if (! valid) {
			throw new IllegalStateException(msg);
		}
	}
	
}
