package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

/**
 * Defers the real component lookup to the first time the actual 
 * value is needed. This allows for the ui system to completely buildup first.
 * 
 * @author bwijsmuller
 * @param <T> the type of widget to lazy load.
 */
public class LazyXwtComponent<T extends Widget> {

	private final Composite parent;
	private final String name;
	private final Class<T> type;
	
	private T instance;

	/**
	 * Creates a new {@link LazyXwtComponent}.
	 * 
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 * @param type the type to load once the instance is needed
	 */
	public LazyXwtComponent(Composite parent, String name, Class<T> type) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Gets the component from the XWT gui state, by name and type.
	 * 
	 * @return T the component
	 * @throws IllegalStateException if the component is not found at runtime.
	 */
	public T getComponent() {
		if (instance == null) {
			instance = XWTUtil.getWidget(parent, name, type);
		}
		Assert.state(instance != null, "Lazy loading XWT component with name ["+name+"] in parent ["+parent+"] cannot be found.");
		return instance;
	}
	
}
