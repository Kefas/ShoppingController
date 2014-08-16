package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

/**
 * @author piotr
 *
 */
public class PrintPanel extends JPanel {
	
	/**
	 * default generate serialVersion
	 */
	private static final long serialVersionUID = -3680201267729278033L;
	
	/**
	 * button previous
	 */
	private JButton btnPrevious;
	
	/**
	 * button next
	 */
	private JButton btnNext;
	
	/**
	 * button food
	 */
	private JButton btnFood;
	
	/**
	 * button alcohol
	 */
	private JButton btnAlcohol;
	
	/**
	 * button chemistry
	 */
	private JButton btnChemistry;
	
	/**
	 * button others
	 */
	private JButton btnOthers;
	
	/**
	 * chart panel
	 */
	private JPanel panel;

	/**
	 * button all categories
	 */
	private JButton btnAllCategories;

	/**
	 * combo box food categories
	 */
	private JComboBox<String> boxFoodCategories;
	
	/**
	 * constructor PrintPanel
	 */
	public PrintPanel() {
		
		btnPrevious = new JButton("previous");
		
		btnNext = new JButton("  next  ");
		
		btnFood = new JButton("food");
		
		btnAlcohol = new JButton("alcohol");
		
		btnChemistry = new JButton("chemistry");
		
		btnOthers = new JButton("others");
		
		panel = new JPanel();
		
		btnAllCategories = new JButton("All categories");
		
		boxFoodCategories = new JComboBox<String>();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(boxFoodCategories, 0, 97, Short.MAX_VALUE)
						.addComponent(btnOthers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnFood, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnChemistry, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnAlcohol, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnAllCategories, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addComponent(btnPrevious)
							.addGap(38)
							.addComponent(btnNext))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(btnPrevious))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAllCategories)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFood)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlcohol)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChemistry)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOthers)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boxFoodCategories, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
					.addGap(15))
		);
		setLayout(groupLayout);
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	public void setBtnPrevious(JButton btnPrevious) {
		this.btnPrevious = btnPrevious;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnFood() {
		return btnFood;
	}

	public void setBtnFood(JButton btnFood) {
		this.btnFood = btnFood;
	}

	public JButton getBtnAlcohol() {
		return btnAlcohol;
	}

	public void setBtnAlcohol(JButton btnAlcohol) {
		this.btnAlcohol = btnAlcohol;
	}

	public JButton getBtnChemistry() {
		return btnChemistry;
	}

	public void setBtnChemistry(JButton btnChemistry) {
		this.btnChemistry = btnChemistry;
	}

	public JButton getBtnOthers() {
		return btnOthers;
	}

	public void setBtnOthers(JButton btnOthers) {
		this.btnOthers = btnOthers;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnAllCategories() {
		return btnAllCategories;
	}

	public void setBtnAllCategories(JButton btnAllCategories) {
		this.btnAllCategories = btnAllCategories;
	}

	public JComboBox<String> getBoxFoodCategories() {
		return boxFoodCategories;
	}

	public void setBoxFoodCategories(JComboBox<String> boxFoodCategories) {
		this.boxFoodCategories = boxFoodCategories;
	}
}
