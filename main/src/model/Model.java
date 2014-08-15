package model;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import controller.Controller;

public class Model extends AbstractModel {
	
	/**
	 * all category
	 */
	public static final String ALL_CATEGORIES = "all";
	
	/**
	 * food category
	 */
	public static final String FOOD_CATEGORY = "food";
	
	/**
	 * alcohol category
	 */
	public static final String ALCOHOL_CATEGORY = "alcohol";
	
	/**
	 * chemistry category
	 */
	public static final String CHEMISTRY_CATEGORY = "chemistry";
	
	/**
	 * others category
	 */
	public static final String OTHERS_CATEGORY = "others";
	
	/**
	 * map with items and categories
	 */
	private Map<String, Double> data;

	private ChartPanel chartPanel;

	@Override
	public void saveEntry(String path, Item addEntry)  {
		try {	
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
		    out.println(
		    		addEntry.getShop() + "," +
		    		addEntry.getCategory() + "," +
		    		(addEntry.getFoodCategory() != null ? addEntry.getFoodCategory() + "," : "") +
					addEntry.getName() + "," + 
					addEntry.getPrice() + "," + 
					addEntry.getDate() + ";" 
		    		);
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printChart(String path) {
		// TODO Auto-generated method stub
		
	}

	/**validate addEntry
	 * 
	 * @param addEntry
	 * @throws Exception
	 */
	public void validateEntry(Item addEntry) throws Exception {
		if(addEntry.getShop().isEmpty() || "shop".equals(addEntry.getShop()))
			throw new Exception("shop");
		if(addEntry.getCategory().isEmpty() || "category".equals(addEntry.getCategory()))
			throw new Exception("category");
		if(addEntry.getName().isEmpty() || "item".equals(addEntry.getName()))
			throw new Exception("item");
		if(addEntry.getPrice().isEmpty())
			throw new Exception("price");
		else if(!addEntry.getPrice().matches("[0-9]*\\.[0-9][0-9]?") && !addEntry.getPrice().matches("[0-9]*"))
			throw new Exception("price format! It should be ex. 10.98");
		if(addEntry.getDate().isEmpty())
			throw new Exception("date");
		if(!addEntry.getDate().matches("[0-3][0-9]-[0-1][0-9]-[0-9][0-9]"))
			throw new Exception("date format");
	}

	/**creating data in chosen category
	 * 
	 * @param chosenCategory
	 */
	public void createData(String chosenCategory) {
		data = new HashMap<String, Double>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Controller.PATH));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] parts = line.split(",");
				int partNo;
				String price;		
		
				if(parts.length == 6)
					price = parts[4];
				else
					price = parts[3];
								
				if(ALL_CATEGORIES.equals(chosenCategory)){
					partNo = 1;
				}
				else
					partNo = 2;
		
				if(ALL_CATEGORIES.equals(chosenCategory) || parts[1].equals(chosenCategory)){
					if(!data.containsKey(parts[partNo]))
						data.put(parts[partNo], Double.parseDouble(price));
					else
						data.put(parts[partNo], data.get(parts[partNo]) + Double.parseDouble(price));
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**creating chartPanel with chart
	 * 
	 * @param title
	 */
	public void createChart(String title) {
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		Double sum = sumUp(data);
		for(Entry<String,Double> entry : data.entrySet())
			defaultPieDataset.setValue(entry.getKey() + String.format("%.2f", entry.getValue()*100/sum) + "% - " + String.format("%.2f", entry.getValue()) + "z³", entry.getValue()*100/sum);
	
		JFreeChart chart = ChartFactory.createPieChart(title, defaultPieDataset, true, false, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
		plot.setLabelGenerator(null);
		plot.setNoDataMessage("No data available");
		plot.setCircular(true);
		plot.setLabelGap(0.02);
		
		chartPanel = new ChartPanel(chart);
	}

	/**sum of all values in map
	 * 
	 * @param data
	 * @return
	 */
	private Double sumUp(Map<String, Double> data) {
		Double sum = new Double(0);
		for(Entry<String,Double> entry: data.entrySet())
			sum += entry.getValue();
		return sum;
	}

	public ChartPanel getChartPanel() {
		return chartPanel;
	}
}
