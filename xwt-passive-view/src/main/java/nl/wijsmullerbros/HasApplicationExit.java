package nl.wijsmullerbros;

/**
 * Contract to something that provides a way to exit the application
 * 
 * @author bwijsmuller
 */
public interface HasApplicationExit {
	/**
	 * Can be called to exit the application.
	 */
	public void exit();
}
