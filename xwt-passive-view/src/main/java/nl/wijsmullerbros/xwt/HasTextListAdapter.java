package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;
import nl.wijsmullerbros.HasTextList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextList} interface.
 * @author bwijsmuller
 */
public class HasTextListAdapter implements HasTextList {

	private final Composite parent;
	private final String name;

	/**
	 * Creates a new {@link HasTextListAdapter}.
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 */
	public HasTextListAdapter(Composite parent, String name) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public void add(String text) {
		Text field = XWTUtil.getField(parent, name);
		field.append("\n" + text);
	}

}
