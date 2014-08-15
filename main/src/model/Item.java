package model;

public class Item {
	private String shop;
	private String category;
	private String foodCategory;
	private String name;
	private String price;
	private String date;
	
	public Item(String shop, String item, String category, String foodCategory, String price, String date){
		this.shop = shop;
		this.name = item;
		this.category = category;
		this.foodCategory = foodCategory;
		this.price = price;
		this.date = date;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getName() {
		return name;
	}

	public void setName(String item) {
		this.name = item;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
}
