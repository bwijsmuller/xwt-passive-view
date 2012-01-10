package nl.wijsmullerbros.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides static access to the injection context that we know will exist
 * at runtime.
 * <br><br>
 * We need this because the XWT system spring-integration is not yet
 * in mature enough stage to actually deliver a usable library (22-11-2011).
 * 
 * @author bwijsmuller
 */
public class InjectorHelper {
		
	private static final Logger logger = LoggerFactory.getLogger(InjectorHelper.class);
	
	private static Injector INJECTOR;
	
	public static void init(Injector injector) {
		logger.debug("Setting new injector [{}] to the static Injector context.", injector);
		InjectorHelper.INJECTOR = injector;
	}
	
	public static <T> T getBean(Class<T> type) {
		T bean = InjectorHelper.INJECTOR.getBean(type);
		if (bean == null) {
			logger.warn("Could not find instance of class [{}] in injection context.", type);
		}
		return bean;
	}

	public static <T> T getBean(String id, Class<T> type) {
		T bean = InjectorHelper.INJECTOR.getBean(id, type);
		if (bean == null) {
			logger.warn("Could not find instance of class [{}] with name [{}] in injection context.", type, id);
		}
		return bean;
	}
	
}
