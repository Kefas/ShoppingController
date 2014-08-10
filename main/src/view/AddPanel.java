package view;

import java.awt.Color;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AddPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8391818543896719891L;
	
	/**
	 * shop name input
	 */
	private JTextField txtShop;
	
	/**
	 * item name input
	 */
	private JTextField txtItem;
	
	
	/**
	 * price input
	 */
	private JTextField txtPrice;
	
	/**
	 * date input
	 */
	private JTextField txtDate;
	
	/**
	 * is first shop name change
	 */
	private boolean firstClickTxtShop;
	
	
	/**
	 * is first item change
	 */
	private boolean firstClickTxtItem;
	
	
	/**
	 * if first price change
	 */
	private boolean firstClickTxtPrice;
	
	
	/**
	 * add Entry button
	 */
	private JButton btnAddEntry;
	
	/**
	 * infor label
	 */
	private JLabel info;
	
	/**
	 * AddPanel constructor
	 */
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
		
		info = new JLabel("");
		add(info, "cell 0 6");
		
		firstClickTxtShop = true;
		firstClickTxtItem = true;
		firstClickTxtPrice = true;
	}

	/**
	 * returns shop JTextField
	 * @return shop JTextField
	 */
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

	public void clear() {
		txtItem.setText("item");
		txtPrice.setText("0.00");
		firstClickTxtShop = true;
		firstClickTxtItem = true;
		firstClickTxtPrice = true;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}

	public void printInfo(String message, int state) {
		info.setText(message);
		if(state == 1)
			info.setForeground(Color.GREEN);
		else
			info.setForeground(Color.RED);
	}
}
