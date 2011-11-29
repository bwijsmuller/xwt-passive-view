package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasTextList;

import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextList} interface.
 * @author bwijsmuller
 */
public class HasTextListAdapter implements HasTextList {

	private final LazyXwtComponent<Text> comp;
	private HasTextListAdapter(LazyXwtComponent<Text> comp) {
		this.comp = comp;
	}
	
	@Override
	public void add(String text) {
		Text field = comp.getComponent();
		field.append("\n" + text);
	}

	public static HasTextList wrap(LazyXwtComponent<Text> textList) {
		return new HasTextListAdapter(textList);
	}

}
