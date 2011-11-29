package nl.wijsmullerbros.inject;

/**
 * Can provide objects with references to services.
 * Contract to hide the actual injection system that is used.
 * 
 * @author bwijsmuller
 */
public interface Injector {

	/**
	 * Looks up the bean in the application context identified by its class.
	 * @param type the class to look for
	 * @return the instance of type T
	 */
	<T> T getBean(Class<T> type);

	<T> T getBean(String id, Class<T> type);
	
}
