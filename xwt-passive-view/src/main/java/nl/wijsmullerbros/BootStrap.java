package nl.wijsmullerbros;

import java.net.URL;

/**
 * Can start the actual window kit that is used, provides the window canvas
 * to render to.
 * 
 * @author bwijsmuller
 */
public interface BootStrap {
	/**
	 * Opens the window and starts rendering. Usually this method
	 * will only return when the application quits.
	 * 
	 * @param configUrl points to the configuration file to use
	 * @throws DisplaySystemRuntimeException when the display system fails
	 */
	void open(URL configUrl) throws DisplaySystemRuntimeException;

	Object getRootWindowReference();
}
