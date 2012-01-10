package nl.wijsmullerbros.xwt;

import nl.wijsmullerbros.Assert;
import nl.wijsmullerbros.BootStrap;

import org.eclipse.swt.widgets.Shell;

/**
 * Shell can be looked up only after the gui has fully loaded,
 * this component can be used for the time the shell is not available yet.
 * 
 * @author bwijsmuller
 */
public class LazyLoadingShell {

	private final BootStrap bootStrap;
	private Shell rootWindowReference = null;

	/**
	 * Creates a new {@link LazyLoadingShell}.
	 * 
	 * @param bootStrap the bootstrap to lookup the shell
	 */
	public LazyLoadingShell(BootStrap bootStrap) {
		Assert.notNull(bootStrap, "Parameter 'bootStrap' cannot be null.");
		this.bootStrap = bootStrap;
	}
	
	/**
	 * Gets the instance of the shell
	 * @return the single Shell instance
	 */
	public Shell get() {
		// thread safety is not so much an issue here since there is only 1 shell
		// and in the worst case it is set twice, we don't mind that happening.
		if (rootWindowReference == null) {
			rootWindowReference = (Shell) bootStrap.getRootWindowReference();
		}
		return rootWindowReference;
	}
	
}
