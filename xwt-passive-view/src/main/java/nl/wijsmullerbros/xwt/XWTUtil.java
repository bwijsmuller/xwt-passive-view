package nl.wijsmullerbros.xwt;

import java.net.URL;

import nl.wijsmullerbros.DisplaySystemRuntimeException;

import org.eclipse.e4.xwt.XWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to lookup various GUI components from XWT.
 * 
 * @author bwijsmuller
 */
public class XWTUtil {

	private static final Logger logger = LoggerFactory.getLogger(XWTUtil.class);
	
	private XWTUtil() {
		//hidden
	}
	
	/**
	 * Convenience method to set the system color as SWT color value
	 * on a widget (control) foreground.
	 * @param control the control to apply the color to
	 * @param color the SWT color value
	 */
	public static void setForegroundColor(Control control, int color) {
		control.setForeground(control.getDisplay().getSystemColor(color));
	}
	
	/**
	 * Performs a widget lookup on the XWT context by name.
	 * 
	 * @param context te parent component to search in
	 * @param xwtName the name to look for
	 * @param type the type to cast to
	 * @return T the found instance cast to the specified type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getWidget(Widget context, String xwtName, Class<T> type) {
		return (T) XWT.findElementByName(context, xwtName);
	}

	/**
	 * Disables or enables a component and all its children components.
	 * @param node the component to disable
	 * @param enable whether to enable or disable
	 * @see #disableEnableRecursive(Composite, boolean)
	 */
	public static void disableEnableRecursive(Control node, boolean enable) {
		if (node instanceof Composite) {
			disableEnableRecursive((Composite) node, enable);
		} else if (node instanceof List) {
			disableEnableRecursive((List) node, enable);
		} else {
			node.setEnabled(enable);
		}
	}
	/**
	 * Disables or enables a composite component and all its children components.
	 * @param node the component to disable
	 * @param enable whether to enable or disable
	 */
	public static void disableEnableRecursive(Composite node, boolean enable) {
		for (Control child : node.getChildren()) {
			disableEnableRecursive(child, enable);
		}
		node.setEnabled(enable);
	}
	/**
	 * Performs a lookup of the named component and reads its text
	 * value as an integer value.
	 * @param context the parent component
	 * @param name the XWT name used
	 * @return the integer value
	 */
	public static Integer readIntegerField(Widget context, String name) {
		String text = readField(context, name);
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException nfe) {
			return null;
		}
	}
	/**
	 * Performs a lookup of the named component and reads its text
	 * value.
	 * @param context the parent component
	 * @param name the XWT name used
	 * @return the text value
	 */
	public static String readField(Widget context, String name) {
		Text text = getField(context, name);
		return text.getText();
	}
	/**
	 * Convenience method that performs a lookup of the named component
	 * and casts it to a SWT Text component.
	 * @param context the parent component
	 * @param name the XWT name used
	 * @return the text component
	 */
	public static Text getField(Widget context, String name) {
		Text result = XWTUtil.getWidget(context, name, Text.class);
		if (result == null) {
			logger.error("Field lookup result was null for name [{}] within parent [{}]", name, context);
		}
		return result;
	}
	/**
	 * Convenience method to load a component from a definition file,
	 * in a new (popup) window shell.
	 * @param parent the parent component to use for loading
	 * @param definitionFileName the XWT xml definition file path
	 * @param type the type of the component to laod
	 * @param width the width of the popup
	 * @param height the height of the popup 
	 * @param title the title to use for the popup
	 * @return the component that was loaded in the popup
	 */
	@SuppressWarnings("unchecked")
	public static <T> T loadInPopupWindow(Control parent, String definitionFileName, Class<T> type,
			int width, int height,
			String title) {
		Shell popup = new Shell(parent.getDisplay(), SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
		popup.setMinimumSize(width, height);
		popup.setLayout(new FillLayout(SWT.VERTICAL));
		popup.setText(title);
		try {
			URL url = XWTUtil.class.getResource(definitionFileName).toURI().toURL();
			T result = (T) XWT.load(popup, url);
			popup.pack();
			popup.open();
			
			return result;
		} catch (Exception e) {
			throw new DisplaySystemRuntimeException(e.getMessage(), e);
		}
	}

}
