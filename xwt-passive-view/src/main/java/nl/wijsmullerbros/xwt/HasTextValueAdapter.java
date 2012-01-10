package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasTextValue;

import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextValue} interface.
 * @author bwijsmuller
 */
public class HasTextValueAdapter implements HasTextValue {

	private final LazyXwtComponent<Text> comp;
	private HasTextValueAdapter(LazyXwtComponent<Text> comp) {
		this.comp = comp;
	}
	
	@Override
	public String getValue() {
		return comp.getComponent().getText();
	}

	@Override
	public void setValue(String value) {
		Text field = comp.getComponent();
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
	public static HasTextValue wrap(LazyXwtComponent<Text> comp) {
		return new HasTextValueAdapter(comp);
	}
	
}
