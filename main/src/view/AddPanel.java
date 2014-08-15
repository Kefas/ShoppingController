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
	 * category input
	 */
	private JTextField txtCategory;
	
	/**
	 * food category input
	 */
	private JTextField txtFoodCategory;
	
	/**
	 * is first shop name change
	 */
	private boolean firstClickTxtShop;
	
	
	/**
	 * is first item change
	 */
	private boolean firstClickTxtItem;
	
	
	/**
	 * is first price change
	 */
	private boolean firstClickTxtPrice;
	
	/**
	 * is first category change
	 */
	private boolean firstClickTxtCategory;
	
	/**
	 * is first food category change
	 */
	private boolean firstClickTxtFoodCategory;
	
	/**
	 * add Entry button
	 */
	private JButton btnAddEntry;
	
	/**
	 * information label
	 */
	private JLabel info;
	
	/**
	 * AddPanel constructor
	 */
	public AddPanel() {
		setLayout(new MigLayout("", "[grow]", "[][][][][][][][]"));
		
		txtShop = new JTextField();
		txtShop.setText("shop");
		add(txtShop, "cell 0 1,alignx leading");
		txtShop.setColumns(10);
		
		txtItem = new JTextField();
		txtItem.setText("item");
		add(txtItem, "cell 0 2,alignx leading");
		txtItem.setColumns(10);
		
		Format format = new SimpleDateFormat("yy-MM-dd");
		
		txtCategory = new JTextField();
		txtCategory.setText("category");
		add(txtCategory, "cell 0 3,alignx left");
		txtCategory.setColumns(10);
		
		txtFoodCategory = new JTextField();
		txtFoodCategory.setText("food category");
		add(txtFoodCategory, "cell 0 4,alignx left");
		txtFoodCategory.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("0.00");
		add(txtPrice, "cell 0 5,alignx leading");
		txtPrice.setColumns(10);
		
		info = new JLabel("");
		add(info, "flowx,cell 0 8");
		
		btnAddEntry = new JButton("Add entry");
		add(btnAddEntry, "cell 0 7");
		
		txtDate = new JTextField();
		txtDate.setText(format.format(Calendar.getInstance().getTime()));
		add(txtDate, "cell 0 6,alignx leading");
		txtDate.setColumns(10);
		
		firstClickTxtShop = true;
		firstClickTxtItem = true;
		firstClickTxtPrice = true;
		firstClickTxtCategory = true;
		firstClickTxtFoodCategory = true;
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
		txtCategory.setText("category");
		txtFoodCategory.setText("food category");
		firstClickTxtShop = true;
		firstClickTxtItem = true;
		firstClickTxtPrice = true;
		firstClickTxtCategory = true;
		firstClickTxtFoodCategory = true;
		
		txtCategory.setEditable(true);
		txtFoodCategory.setEditable(true);
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

	public JTextField getTxtCategory() {
		return txtCategory;
	}

	public void setTxtCategory(JTextField txtCategory) {
		this.txtCategory = txtCategory;
	}

	public JTextField getTxtFoodCategory() {
		return txtFoodCategory;
	}

	public void setTxtFoodCategory(JTextField txtFoodCategory) {
		this.txtFoodCategory = txtFoodCategory;
	}

	public void categoryReset() {
		txtCategory.setText("category");
		txtFoodCategory.setText("food category");
		txtCategory.setEditable(true);
		txtFoodCategory.setEditable(true);
	}

	public boolean isFirstClickTxtCategory() {
		return firstClickTxtCategory;
	}

	public void setFirstClickTxtCategory(boolean firstClickTxtCategory) {
		this.firstClickTxtCategory = firstClickTxtCategory;
	}

	public boolean isFirstClickTxtFoodCategory() {
		return firstClickTxtFoodCategory;
	}

	public void setFirstClickTxtFoodCategory(boolean firstClickTxtFoodCategory) {
		this.firstClickTxtFoodCategory = firstClickTxtFoodCategory;
	}
}
