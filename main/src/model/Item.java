package model;

/**
 * @author piotr
 *
 */
public class Item {
	/**
	 * shop name
	 */
	private String shop;
	
	/**
	 * category
	 */
	private String category;
	
	
	/**
	 * food category
	 */
	private String foodCategory;
	
	/**
	 * item name
	 */
	private String name;
	
	/**
	 * item price
	 */
	private String price;
	
	/**
	 * date of buying
	 */
	private String date;
	
	/**Item constructor
	 * 
	 * @param shop
	 * @param item
	 * @param category
	 * @param foodCategory
	 * @param price
	 * @param date
	 */
	public Item(String shop, String item, String category, String foodCategory, String price, String date){
		this.shop = shop;
		this.name = item;
		this.category = category;
		this.foodCategory = foodCategory;
		this.price = price;
		this.date = date;
	}

	/**get shop name
	 * @return shop name
	 */
	public String getShop() {
		return shop;
	}

	/**set shop name
	 * @param shop
	 */
	public void setShop(String shop) {
		this.shop = shop;
	}

	/**get item name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**set item name
	 * @param item
	 */
	public void setName(String item) {
		this.name = item;
	}

	/**get item price
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**set item price
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**get item date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**set item date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**get item category
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**set item category
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**get item food category
	 * @return food category
	 */
	public String getFoodCategory() {
		return foodCategory;
	}

	/**set item food category
	 * @param foodCategory
	 */
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
}
