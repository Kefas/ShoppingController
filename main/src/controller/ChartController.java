package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Model;
import view.PrintPanel;
import view.View;

public class ChartController {	

	/**
	 * printPanel with charts
	 */
	private PrintPanel printPanel;
	
	/**
	 * model
	 */
	private Model model;
	
	/**
	 * view
	 */
	private View view;

	/**
	 * data format
	 */
	private Format format;

	private Format fileFormat;
	
	/**
	 * ChartController constructor
	 * @param view 
	 * @param model 
	 */
	public ChartController(Model model, View view){
		this.model = model;
		this.view = view;
		
		format = new SimpleDateFormat("MM.yyyy");
		fileFormat = new SimpleDateFormat("yyMM");
		
		printPanel = new PrintPanel();
		
		model.actualizeFoodCategory(fileFormat.format(Calendar.getInstance().getTime()) + ".txt");
		
		for(String entry : model.getActualFoodCategories())
			printPanel.getBoxFoodCategories().addItem(entry);
		
		printPanel.getBtnAllCategories().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart(Model.ALL_CATEGORIES);
			}
		});
		printPanel.getBtnFood().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart(Model.FOOD_CATEGORY);
			}
		});
		printPanel.getBtnAlcohol().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart(Model.ALCOHOL_CATEGORY);
			}
		});
		printPanel.getBtnChemistry().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart(Model.CHEMISTRY_CATEGORY);
			}
		});
		printPanel.getBtnOthers().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart(Model.OTHERS_CATEGORY + "Category");
			}
		});	
		printPanel.getBoxFoodCategories().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart((String)printPanel.getBoxFoodCategories().getSelectedItem());
			}
		});
		
		view.setChildPanel(printPanel);
	}
	
	/**create and add chart category to panel
	 * 
	 * @param category
	 */
	private void createChart(String category) {
		model.createData(category);
		model.createChart(category+ " " + format.format(Calendar.getInstance().getTime()));
		printPanel.getPanel().setLayout(new BorderLayout());
		printPanel.getPanel().removeAll();
		printPanel.getPanel().add(model.getChartPanel(), BorderLayout.CENTER);
		view.setChildPanel(printPanel);
	}

	public PrintPanel getPrintPanel() {
		return printPanel;
	}

	public void setPrintPanel(PrintPanel printPanel) {
		this.printPanel = printPanel;
	}
}
