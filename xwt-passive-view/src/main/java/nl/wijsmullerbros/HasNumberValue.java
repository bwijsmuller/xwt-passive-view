package nl.wijsmullerbros;

/**
 * Contract to something that allows for a text number value
 * to be read and set.
 * @author bwijsmuller
 */
public interface HasNumberValue {
	/**
	 * Can be called to get the component integer value
	 * @return the integer value
	 */
	Integer getValue();
	/**
	 * Can be called to set the component integer value
	 * @param value as integer
	 */
	void setValue(Integer value);
}
