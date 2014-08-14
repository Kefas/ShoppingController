package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Item;
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
