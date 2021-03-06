package model;

public abstract class AbstractModel {
	
	/**
	 * save entry in file in given path
	 * @param path
	 */
	public abstract void saveEntry(String path, Item addEntry);
	
	/**
	 * print chart in file in given path
	 * @param path
	 */
	public abstract void printChart(String path);

	
	
}
