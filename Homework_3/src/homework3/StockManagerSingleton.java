package homework3;

import java.util.ArrayList;
import java.util.Scanner;

import mediaProducts.MediaProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton 
{
	private static StockManagerSingleton instance = null;
	private final static String inventoryFilePath = "inventory.csv";
	
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
			String type;
			String title;
			double price;
			int year;
			Genre fileGenre = null;
			
			String temp;
			
			
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			fileIn.useDelimiter("\n");
			
			while(fileIn.hasNext())
			{
				type = fileIn.next();
				title = fileIn.next();
				price = fileIn.nextDouble();
				year = fileIn.nextInt();
				temp = fileIn.next();
				
				switch(temp)
				{
					case "ROCK":
					{
						fileGenre = Genre.ROCK;
					}
					case "POP":
					{
						fileGenre = Genre.POP;
					}
					case "JAZZ":
					{
						fileGenre = Genre.JAZZ;
					}
					case "CLASSICAL":
					{
						fileGenre = Genre.CLASSICAL;
					}
					case "HIP_HOP":
					{
						fileGenre = Genre.HIP_HOP;
					}
					case "ELECTRONIC":
					{
						fileGenre = Genre.ELECTRONIC;
					}
					case "CHILDREN":
					{
						fileGenre = Genre.CHILDREN;
					}
					default:
					{
						System.out.println("Invalid File Data");
					}
				}
				 
				masterInventory.add(new MediaProduct(title, price, year, fileGenre));
			}
			return true;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
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

