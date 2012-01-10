package nl.wijsmullerbros;

/**
 * Contract to something that exposes a enable/disable aspect.
 * @author bwijsmuller
 */
public interface HasEnabledState {
	/**
	 * Can be called to enable the component
	 */
	void enable();
	/**
	 * Can be called to disable the component
	 */
	void disable();
	/**
	 * Can be called to enable or disable the component
	 * based on a variable.
	 * @param enable whether to enable or disable
	 */
	void setEnabled(boolean enable);
}
