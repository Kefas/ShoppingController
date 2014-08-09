package view;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8391818543896719891L;
	private JTextField txtShop;
	private JTextField txtItem;
	private JTextField txtPrice;
	private JTextField txtDate;
	private boolean firstClickTxtShop;
	private boolean firstClickTxtItem;
	private boolean firstClickTxtPrice;
	private JButton btnAddEntry;
	
	public AddPanel() {
		setLayout(new MigLayout("", "[grow]", "[][][][][][]"));
		
		txtShop = new JTextField();
		txtShop.setText("shop");
		add(txtShop, "cell 0 1,alignx leading");
		txtShop.setColumns(10);
		
		txtItem = new JTextField();
		txtItem.setText("item");
		add(txtItem, "cell 0 2,alignx leading");
		txtItem.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("0.00");
		add(txtPrice, "cell 0 3,alignx leading");
		txtPrice.setColumns(10);
		
		Format format = new SimpleDateFormat("dd-MM-yy");
		
		txtDate = new JTextField();
		txtDate.setText(format.format(Calendar.getInstance().getTime()));
		add(txtDate, "cell 0 4,alignx leading");
		txtDate.setColumns(10);
		
		btnAddEntry = new JButton("Add entry");
		add(btnAddEntry, "cell 0 5");
		
		firstClickTxtShop = true;
		firstClickTxtItem = true;
		firstClickTxtPrice = true;
	}

	public JTextField getTxtShop() {
		return txtShop;
	}

	public void setTxtShop(JTextField txtShop) {
		this.txtShop = txtShop;
	}

	public JTextField getTxtItem() {
		return txtItem;
	}

	public void setTxtItem(JTextField txtItem) {
		this.txtItem = txtItem;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public void setTxtPrice(JTextField txtPrice) {
		this.txtPrice = txtPrice;
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}
	
	public void setFirstClickTxtPrice(boolean state){
		firstClickTxtPrice = state;
	}

	public boolean isFirstClickTxtPrice() {
		return firstClickTxtPrice;
	}

	public JButton getBtnAddEntry() {
		return btnAddEntry;
	}

	public void setBtnAddEntry(JButton btnAddEntry) {
		this.btnAddEntry = btnAddEntry;
	}

	public boolean isFirstClickTxtShop() {
		return firstClickTxtShop;
	}

	public void setFirstClickTxtShop(boolean firstClickTxtShop) {
		this.firstClickTxtShop = firstClickTxtShop;
	}

	public boolean isFirstClickTxtItem() {
		return firstClickTxtItem;
	}

	public void setFirstClickTxtItem(boolean firstClickTxtItem) {
		this.firstClickTxtItem = firstClickTxtItem;
	}
}
