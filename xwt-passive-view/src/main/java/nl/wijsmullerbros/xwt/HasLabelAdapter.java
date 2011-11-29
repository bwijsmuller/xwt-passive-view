package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;
import nl.wijsmullerbros.HasTextValue;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextValue} interface.
 * @author bwijsmuller
 */
public class HasLabelAdapter implements HasTextValue {

	private final Composite parent;
	private final String name;

	/**
	 * Creates a new {@link HasLabelAdapter}.
	 * @param parent a reference to the parent to use as context
	 * @param name the name of the component to lookup in static XWT map
	 */
	public HasLabelAdapter(Composite parent, String name) {
		Assert.notNull(parent, "Parameter 'parent' cannot be null");
		Assert.notNull(name, "Parameter 'name' cannot be null");
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public String getValue() {
		Label label = XWTUtil.getWidget(parent, name, Label.class);
		return label.getText();
	}

	@Override
	public void setValue(String value) {
		Label field = XWTUtil.getWidget(parent, name, Label.class);
		if (value != null) {
			field.setText(value);
		} else {
			field.setText("");
		}
	}

}
