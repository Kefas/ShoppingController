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
	
	/**
	 * ChartController constructor
	 * @param view 
	 * @param model 
	 */
	public ChartController(Model model, View view){
		this.model = model;
		this.view = view;
		
		format = new SimpleDateFormat("MM.yyyy");
		
		printPanel = new PrintPanel();
		
		printPanel.getBtnAllCategories().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnAllCategories();
			}
		});
		printPanel.getBtnFood().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnFood();
			}
		});
		printPanel.getBtnAlcohol().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnAlcohol();
			}
		});
		printPanel.getBtnChemistry().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnChemistry();
			}
		});
		printPanel.getBtnOthers().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				handlerBtnOthers();
			}
		});	
		
		view.setChildPanel(printPanel);
	}
	
	protected void handlerBtnAllCategories() {
		model.createData(Model.ALL_CATEGORIES);
		model.createChart("All categories " + format.format(Calendar.getInstance().getTime()));
		addChart();
	}

	private void addChart() {
		printPanel.getPanel().setLayout(new BorderLayout());
		printPanel.getPanel().add(model.getChartPanel(), BorderLayout.CENTER);
		view.setChildPanel(printPanel);
	}

	/**
	 * handle food button
	 */
	protected void handlerBtnFood() {
		model.createData(Model.FOOD_CATEGORY);
		model.createChart("food" + format.format(Calendar.getInstance().getTime()));
		addChart();
	}
	
	/**
	 * handle alcohol button
	 */
	protected void handlerBtnAlcohol() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * handle chemistry button
	 */
	protected void handlerBtnChemistry() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * handle others button
	 */
	protected void handlerBtnOthers() {
		// TODO Auto-generated method stub
		
	}

	public PrintPanel getPrintPanel() {
		return printPanel;
	}

	public void setPrintPanel(PrintPanel printPanel) {
		this.printPanel = printPanel;
	}

}
