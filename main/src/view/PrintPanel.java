package view;

import java.util.Map;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PrintPanel extends JPanel {
	
	private Map<String, Map<String, ?>> items;
	
	/**
	 * default generate serialVersion
	 */
	private static final long serialVersionUID = -3680201267729278033L;
	
	public PrintPanel() {
		setLayout(new MigLayout("", "[]", "[]"));
	}

	public Map<String, Map<String, ?>> getItems() {
		return items;
	}

	public void setItems(Map<String, Map<String, ?>> items) {
		this.items = items;
	}


	
}
