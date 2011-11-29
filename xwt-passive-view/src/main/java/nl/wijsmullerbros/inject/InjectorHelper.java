package nl.wijsmullerbros.inject;

/**
 * Provides static access to the injection context that we know will exist
 * at runtime.
 * <br /><br />
 * We need this because the XWT system spring-integration is not yet
 * in mature enough stage to actually deliver a usable library (22-11-2011).
 * 
 * @author bwijsmuller
 */
public class InjectorHelper {
		
	private static Injector INJECTOR;
	
	public static void init(Injector injector) {
		InjectorHelper.INJECTOR = injector;
	}
	
	public static <T> T getBean(Class<T> type) {
		return InjectorHelper.INJECTOR.getBean(type);
	}

	public static <T> T getBean(String id, Class<T> type) {
		return InjectorHelper.INJECTOR.getBean(id, type);
	}
	
}
