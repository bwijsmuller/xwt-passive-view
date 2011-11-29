package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;
import nl.wijsmullerbros.HasNumberValue;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasNumberValue} interface.
 * @author bwijsmuller
 */
public class HasNumberAdapter implements HasNumberValue {

	private final Composite parent;
	private final String name;

	/**
	 * Creates a new {@link HasNumberAdapter}.
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 */
	public HasNumberAdapter(Composite parent, String name) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
	}

	@Override
	public Integer getValue() {
		return XWTUtil.readIntegerField(parent, name);
	}

	@Override
	public void setValue(Integer value) {
		Text field = XWTUtil.getField(parent, name);
		if (value != null) {
			field.setText(""+value);
		} else {
			field.setText("");
		}
	}

}
