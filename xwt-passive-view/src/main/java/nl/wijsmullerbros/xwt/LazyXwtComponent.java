/**
 * 
 */
package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

/**
 * @author bwijsmuller
 */
public class LazyXwtComponent<T extends Widget> {

	private final Composite parent;
	private final String name;
	private final Class<T> type;
	
	private T instance;

	/**
	 * Creates a new {@link LazyXwtComponent}.
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 */
	public LazyXwtComponent(Composite parent, String name, Class<T> type) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
		this.type = type;
	}
	
	public T getComponent() {
		if (instance == null) {
			instance = XWTUtil.getWidget(parent, name, type);
		}
		return instance;
	}
	
}
