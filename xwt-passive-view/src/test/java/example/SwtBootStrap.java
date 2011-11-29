package example;

import java.net.URL;

import nl.wijsmullerbros.BootStrap;
import nl.wijsmullerbros.DisplaySystemRuntimeException;

import org.eclipse.e4.xwt.XWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author bwijsmuller
 */
public class SwtBootStrap implements BootStrap {
	
	private Shell shell;
	
	@Override
	public Object getRootWindowReference() {
		return shell;
	}

	@Override
	public void open(URL configUrl) throws DisplaySystemRuntimeException {
		Display display = new Display();
		try {
			shell = (Shell) XWT.load(configUrl);
			shell.pack();
			shell.open();
			
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			throw new DisplaySystemRuntimeException(e.getMessage(), e);
		} finally {
			display.dispose();
		}
	}
	
}
