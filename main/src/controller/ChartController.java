package controller;

import view.PrintPanel;

public class ChartController {
	private PrintPanel printPanel;
	public ChartController(){
		this.setPrintPanel(new PrintPanel());
	}
	
	public void printChart(){
		makeShopItems("");
	}

	private void makeShopItems(String string) {
		// TODO Auto-generated method stub
		
	}

	public PrintPanel getPrintPanel() {
		return printPanel;
	}

	public void setPrintPanel(PrintPanel printPanel) {
		this.printPanel = printPanel;
	}

}
