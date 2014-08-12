package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class PrintPanel extends JPanel {
	
	/**
	 * default generate serialVersion
	 */
	private static final long serialVersionUID = -3680201267729278033L;
	
	public PrintPanel() {
		setLayout(new MigLayout("", "[]", "[]"));
	} 
	
}
