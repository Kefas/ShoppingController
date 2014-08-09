package model;

public class Model extends AbstractModel {

	@Override
	public void saveEntry(String path) {
		
	}

	@Override
	public void printChart(String path) {
		// TODO Auto-generated method stub
		
	}

	public void validateEntry(AddEntry addEntry) throws Exception {
		if(addEntry.getShop().isEmpty())
			throw new Exception("shop");
		if(addEntry.getItem().isEmpty())
			throw new Exception("item");
		if(addEntry.getPrice().isEmpty())
			throw new Exception("price");
		else if(!addEntry.getPrice().matches("[0-9]*\\.[0-9][0-9]?") && !addEntry.getPrice().matches("[0-9]*"))
			throw new Exception("price format");
		if(addEntry.getDate().isEmpty())
			throw new Exception("date");
		if(!addEntry.getDate().matches("[0-3][0-9]-[0-1][0-9]-[0-9][0-9]"))
			throw new Exception("date format");
	}
}
