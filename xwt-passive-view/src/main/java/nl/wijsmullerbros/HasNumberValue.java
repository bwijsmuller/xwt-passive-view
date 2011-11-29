package nl.wijsmullerbros;

/**
 * Contract to something that allows for a text number value
 * to be read and set.
 * @author bwijsmuller
 */
public interface HasNumberValue {
	Integer getValue();
	void setValue(Integer value);
}
