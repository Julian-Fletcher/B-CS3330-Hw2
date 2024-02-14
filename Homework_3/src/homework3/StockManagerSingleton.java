package homework3;

import java.util.ArrayList;
import java.util.Scanner;

import mediaProducts.MediaProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton 
{
	private static StockManagerSingleton instance = null;
	private final static String inventoryFilePath = "inventory.txt";
	
	// Media storage generic
	ArrayList<MediaProduct> masterInventory = new ArrayList<>();	
	
	
	private StockManagerSingleton()
	{
	}
	
	public static StockManagerSingleton getInstance() 
	{
		if(instance == null)
		{
			instance = new StockManagerSingleton();
		}
		return instance;
	}
	
	public boolean initializeStock()
	{
		try
		{
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/* Methods */
	
	// Add Item
	public boolean addItem(MediaProduct product) {
		masterInventory.add(product);
		return true; // No error checking right now
	}
	
	// Displays media stocks in the provided list
	public void printListOfMediaProduct(ArrayList<MediaProduct>productList) {
		// Iterate through the media provided media list
		for(MediaProduct product : productList) {
			System.out.println(product.toString()); // Use the toString to display the object details
		}
	}
	
}

