package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.HasEnabledState;

import org.eclipse.swt.widgets.Control;

/**
 * Adapts a XWT field inside a parent widget
 * to the {@link HasEnabledState} interface.
 * @author bwijsmuller
 */
public class HasEnabledStateAdapter implements HasEnabledState {

	private final LazyXwtComponent<?> comp;
	private HasEnabledStateAdapter(LazyXwtComponent<?> comp) {
		this.comp = comp;
	}
	
	@Override
	public void enable() {
		setEnabled(true);
	}

	@Override
	public void disable() {
		setEnabled(false);
	}

	@Override
	public void setEnabled(boolean enable) {
		Control control = (Control) comp.getComponent();
		XWTUtil.disableEnableRecursive(control, enable);
	}

	/**
	 * Wraps the lazy loading component.
	 * @param comp the component
	 * @return component adapted to HasEnabledState
	 */
	public static HasEnabledState wrap(LazyXwtComponent<?> comp) {
		return new HasEnabledStateAdapter(comp);
	}

}
