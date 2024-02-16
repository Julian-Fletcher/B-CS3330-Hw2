package homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mediaProducts.MediaProduct;
import mediaProducts.VinylRecordProduct;
import mediaProducts.TapeRecordProduct;
import mediaProducts.CDRecordProduct;

public class StockManagerSingleton 
{
	private static StockManagerSingleton instance = null;
	//src/homework2/studentData.txt
	private final static String inventoryFilePath = "src/homework3/inventory.csv";
	
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
			Genre fileGenre = null;
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			//fileIn.useDelimiter(",|\n");
			
			while(fileIn.hasNext())
			{
				String nextLine = fileIn.nextLine();
				String[] token = nextLine.split(",|\n");
				
				String type = token[0];
				String title = token[1];	
				double price = Double.parseDouble(token[2]);	
				int year = Integer.parseInt(token[3]);			
				String temp = token[4];	
				
				/*
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
				*/
				 
				//masterInventory.add(new MediaProduct(title, price, year, fileGenre));
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

	// Remove Item
	public boolen removeItem(MediaProduct product) {
		if)masterInventory.remove(product)) {
			saveStock();
			return true;
		}
		return false;
	}
	// Save Stock
	public boolen saveStock(){
		try{ 
			FileWriter writer = new FileWriter(inventoryFIlePath);
			for(MediaProduct product : masterInventory) {
				writer.write(product.toCSVFFormat() + "\n");
			}
			writer.close();
			return true;
 		}
		catch (IOEcpection e) {
			e.printStackTrace();
			return false;
		}
	}
 // Method to get media products below a certain price
	public ArrayList<MediaProduct> get MediaProductBelowPrice(double maxPrice) {
		return InventoryFilter.getMediaProductBelowPrice(masterInventory, macPrice);

	}
	// Displays media stocks in the provided list
	public void printListOfMediaProduct(ArrayList<MediaProduct>productList) {
		// Iterate through the media provided media list
		for(MediaProduct product : productList) {
			System.out.println(product.toString()); // Use the toString to display the object details
		}
	}


	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		ArrayList<VinylRecordProduct> vinyls = new ArrayList<>();
		for(MediaProduct product : productList){
			if(product instanceof VinylRecordProduct){
				vinyls.add((VinylRecordProduct) product);
			}
		}
		return vinyls;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		
		ArrayList<CDRecordProduct> cds = new ArrayList<>();
		for(MediaProduct product : productList){
			if(product instanceof CDRecordProduct){
				cds.add((CDRecordProduct) product);
			}
		}
		
		return cds;
		
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		ArrayList<TapeRecordProduct> tapes = new ArrayList<>();
		for(MediaProduct product : productList){
			if(product instanceof TapeRecordProduct){
				tapes.add((TapeRecordProduct) product);
			}
		}
		return tapes;
	}


	
}

