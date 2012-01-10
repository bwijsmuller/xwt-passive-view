package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasTextList;

import org.eclipse.swt.widgets.Text;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextList} interface.
 * @author bwijsmuller
 */
public class HasTextListAdapter implements HasTextList {

	private static final String NEWLINE = "\n";
	
	private final LazyXwtComponent<Text> comp;
	private HasTextListAdapter(LazyXwtComponent<Text> comp) {
		this.comp = comp;
	}
	
	@Override
	public void add(String text) {
		Text field = comp.getComponent();
		field.append(NEWLINE + text);
	}

	/**
	 * Wraps the lazy loading component.
	 * @param comp the component
	 * @return component adapted to HasTextList
	 */
	public static HasTextList wrap(LazyXwtComponent<Text> comp) {
		return new HasTextListAdapter(comp);
	}

}
