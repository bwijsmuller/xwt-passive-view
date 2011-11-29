/**
 * 
 */
package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasNumberValue;

import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasNumberValue} interface.
 * @author bwijsmuller
 */
public class HasNumberAdapter implements HasNumberValue {

	private final LazyXwtComponent<Text> comp;
	private HasNumberAdapter(LazyXwtComponent<Text> comp) {
		this.comp = comp;
	}

	@Override
	public Integer getValue() {
		Text text = comp.getComponent();
		try {
			return Integer.parseInt(text.getText());
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	@Override
	public void setValue(Integer value) {
		Text field = comp.getComponent();
		if (value != null) {
			field.setText(""+value);
		} else {
			field.setText("");
		}
	}

	public static HasNumberValue wrap(LazyXwtComponent<Text> numberText) {
		return new HasNumberAdapter(numberText);
	}

}
