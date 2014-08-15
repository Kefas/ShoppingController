package controller;

import view.PrintPanel;

public class ChartController {	
	
	/**
	 * printPanel with charts
	 */
	private PrintPanel printPanel;
	
	/**
	 * ChartController constructor
	 */
	public ChartController(){
		this.setPrintPanel(new PrintPanel());
	}
	
	/**
	 * printChart on PrintPanel
	 */
	public void printChart(){
		makeShopItems("");
	}

	/**read items from file and set up map with group of items
	 * 
	 * @param string path to file with items
	 */
	private void makeShopItems(String string) {

	}

	public PrintPanel getPrintPanel() {
		return printPanel;
	}

	public void setPrintPanel(PrintPanel printPanel) {
		this.printPanel = printPanel;
	}

}
