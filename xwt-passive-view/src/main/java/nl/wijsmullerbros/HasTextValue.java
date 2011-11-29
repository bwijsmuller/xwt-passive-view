package nl.wijsmullerbros;

/**
 * Contract to something that allows for a text value
 * to be read and set.
 * @author bwijsmuller
 */
public interface HasTextValue {
	String getValue();
	void setValue(String value);
}
