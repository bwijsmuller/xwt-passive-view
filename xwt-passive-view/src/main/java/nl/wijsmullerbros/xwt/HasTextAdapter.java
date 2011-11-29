package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;
import nl.wijsmullerbros.HasTextValue;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextValue} interface.
 * @author bwijsmuller
 */
public class HasTextAdapter implements HasTextValue {

	private final Composite parent;
	private final String name;

	/**
	 * Creates a new {@link HasTextAdapter}.
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 */
	public HasTextAdapter(Composite parent, String name) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public String getValue() {
		return XWTUtil.readField(parent, name);
	}

	@Override
	public void setValue(String value) {
		Text field = XWTUtil.getField(parent, name);
		if (value != null) {
			field.setText(value);
		} else {
			field.setText("");
		}
	}
	
}
