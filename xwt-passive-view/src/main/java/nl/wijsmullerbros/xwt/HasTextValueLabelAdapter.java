package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasTextValue;

import org.eclipse.swt.widgets.Label;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextValue} interface.
 * @author bwijsmuller
 */
public class HasTextValueLabelAdapter implements HasTextValue {

	private final LazyXwtComponent<Label> comp;
	private HasTextValueLabelAdapter(LazyXwtComponent<Label> comp) {
		this.comp = comp;
	}
	
	@Override
	public String getValue() {
		return comp.getComponent().getText();
	}

	@Override
	public void setValue(String value) {
		Label field = comp.getComponent();
		if (value != null) {
			field.setText(value);
		} else {
			field.setText("");
		}
	}

	/**
	 * Wraps the lazy loading component.
	 * @param comp the component
	 * @return component adapted to HasTextValue
	 */
	public static HasTextValue wrap(LazyXwtComponent<Label> comp) {
		return new HasTextValueLabelAdapter(comp);
	}

}
