package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Model extends AbstractModel {

	@Override
	public void saveEntry(String path, AddEntry addEntry)  {
		try {	
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
		    out.println(
		    		addEntry.getShop() + "," +
					addEntry.getItem() + "," + 
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

	public void validateEntry(AddEntry addEntry) throws Exception {
		if(addEntry.getShop().isEmpty() || "shop".equals(addEntry.getShop()))
			throw new Exception("shop");
		if(addEntry.getItem().isEmpty() || "item".equals(addEntry.getItem()))
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
}
