package nl.wijsmullerbros;

/**
 * Contract to something that exposes a enable/disable aspect.
 * @author bwijsmuller
 */
public interface HasEnabledState {
	void enable();
	void disable();
	void setEnabled(boolean enable);
}
