package nl.wijsmullerbros;

/**
 * @author bwijsmuller
 *
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
	
}
