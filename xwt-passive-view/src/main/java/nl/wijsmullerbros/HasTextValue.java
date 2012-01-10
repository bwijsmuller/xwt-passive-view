package nl.wijsmullerbros;

/**
 * Contract to something that allows for a text value
 * to be read and set.
 * @author bwijsmuller
 */
public interface HasTextValue {
	/**
	 * Can be called to get the component text value
	 * @return the text
	 */
	String getValue();
	/**
	 * Can be called to set the component text value
	 * @param value to set
	 */
	void setValue(String value);
}
