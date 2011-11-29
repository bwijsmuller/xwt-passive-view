package nl.wijsmullerbros.xwt;

import org.eclipse.e4.xwt.XWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to lookup various gui components from XWT.
 * @author bwijsmuller
 */
public class XWTUtil {

	private static final Logger logger = LoggerFactory.getLogger(XWTUtil.class);
	
	private XWTUtil() {
		//hidden
	}
	
	public static void setForegroundColor(Control control, int color) {
		control.setForeground(control.getDisplay().getSystemColor(color));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getWidget(Widget context, String xwtName, Class<T> type) {
		return (T) XWT.findElementByName(context, xwtName);
	}

	public static void disableEnableRecursive(Control node, boolean enable) {
		if (node instanceof Composite) {
			disableEnableRecursive((Composite) node, enable);
		} else if (node instanceof List) {
			disableEnableRecursive((List) node, enable);
		} else {
			node.setEnabled(enable);
		}
	}
	public static void disableEnableRecursive(Composite node, boolean enable) {
		for (Control child : node.getChildren()) {
			disableEnableRecursive(child, enable);
		}
		node.setEnabled(enable);
	}
	
	public static  Integer readIntegerField(Widget context, String name) {
		String text = readField(context, name);
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException nfe) {
			return null;
		}
	}
	
	public static String readField(Widget context, String name) {
		Text text = getField(context, name);
		return text.getText();
	}
	
	public static Text getField(Widget context, String name) {
		Text result = XWTUtil.getWidget(context, name, Text.class);
		if (result == null) {
			logger.error("Field lookup result was null for name [{}] within parent [{}]", name, context);
		}
		return result;
	}

}
