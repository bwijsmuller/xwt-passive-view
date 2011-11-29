package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasTextList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasTextList} interface.
 * @author bwijsmuller
 */
public class MenuHasTextListAdapter implements HasTextList {

	private final LazyXwtComponent<Menu> comp;
	private MenuHasTextListAdapter(LazyXwtComponent<Menu> comp) {
		this.comp = comp;
	}

	@Override
	public void add(String text) {
		Menu widget = comp.getComponent();
		new MenuItem(widget, SWT.CHECK).setText(text);
	}

	public static HasTextList wrap(LazyXwtComponent<Menu> menu) {
		return new MenuHasTextListAdapter(menu);
	}

}
