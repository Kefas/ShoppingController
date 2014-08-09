package model;

public class AddEntry {
	private String shop;
	private String item;
	private String price;
	private String date;
	
	public AddEntry(String shop, String item, String price, String date){
		this.shop = shop;
		this.item = item;
		this.price = price;
		this.date = date;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
