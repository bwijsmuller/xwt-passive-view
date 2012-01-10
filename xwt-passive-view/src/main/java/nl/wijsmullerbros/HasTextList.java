package nl.wijsmullerbros;

/**
 * Contract to something that allows for a text value
 * to be added to a listing of text values.
 * @author bwijsmuller
 */
public interface HasTextList {
	/**
	 * Can be called to add text to the list
	 * of the component
	 * @param text the text to add
	 */
	void add(String text);
}
