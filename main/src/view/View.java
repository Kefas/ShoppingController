package view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class View extends JFrame {

	/**
	 * generated serial version
	 */
	private static final long serialVersionUID = 2118299654730994785L;

	/**
	 * add button
	 */
	private JButton btnAdd;
	
	/**
	 * print button
	 */
	private JButton btnPrint;
	
	
	/**
	 * show button
	 */
	private JButton btnShow;
	
	
	/**
	 * main panel
	 */
	private JPanel panel;
	
	/**
	 * childPanel
	 */
	private JPanel childPanel;
	
	/**
	 * success code
	 */
	static public final int SUCCESS = 1;
	
	/**
	 * failure code
	 */
	static public final int FAILURE = 0;
	
	/**
	 * View constructor
	 */
	public View(){
		setTitle("ShoppingController");
		setSize(460, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(460, 320));
		getContentPane().setLayout(new MigLayout("", "[55px][59px][59px][]", "[23px][][][][][]"));
		
		btnAdd = new JButton("Add");
		btnAdd.setMargin(new Insets(0, 0, 0, 0));
		getContentPane().add(btnAdd, "cell 0 0,grow");
		
		btnPrint = new JButton("Print");
		btnPrint.setMargin(new Insets(0, 0, 0, 0));
		getContentPane().add(btnPrint, "cell 1 0,grow");
		
		btnShow = new JButton("Show");
		btnShow.setMargin(new Insets(0, 0, 0, 0));
		getContentPane().add(btnShow, "cell 2 0,grow");
		
		panel = new JPanel();
		panel.setBounds(30, 30, 200, 200);
		getContentPane().add(panel, "cell 0 2 4 4");
	}
	
	/**
	 * returns add button
	 * @return add Button
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/** 
	 * returns print button
	 * @return print Button
	 */
	public JButton getBtnPrint() {
		return btnPrint;
	}

	/**
	 * returns show button
	 * @return show Button
	 */
	public JButton getBtnShow() {
		return btnShow;
	}

	/**
	 * returns panel
	 * @return JPanel
	 */
	public JPanel getPanel() {
		return panel;
	}
	
	/**
	 * set panel
	 * @param panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * returns childPanel
	 * @return childPanel
	 */
	public JPanel getChildPanel() {
		return childPanel;
	}

	/**
	 * set childPanel
	 * @param childPanel
	 */
	public void setChildPanel(JPanel childPanel) {
		this.childPanel = childPanel;
		this.panel.removeAll();
		this.panel.add(childPanel, MigLayout.class);
		this.panel.revalidate();
		this.panel.repaint();	
	}
}
