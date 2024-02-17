package homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import mediaProducts.MediaProduct;
import mediaProducts.VinylRecordProduct;
import mediaProducts.TapeRecordProduct;
import mediaProducts.CDRecordProduct;

public class StockManagerSingleton 
{
	private static StockManagerSingleton instance = null;
	private final static String inventoryFilePath = "files/inventory.csv";
	
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
			fileIn.nextLine(); 					//assuming that the file element line is present - Julian changed to just skip the line
												//get rid of that line
			while(fileIn.hasNext())
			{
				String nextLine = fileIn.nextLine();
				String [] token = nextLine.split(","); //token out each element
				
				String type = token[0]; //this element isn't in our MediaProduct constructor, but I needed it tokened out
				String title = token[1];
				double price = Double.parseDouble(token[2]); //parse numeric values
				int year = Integer.parseInt(token[3]);
				Genre fileGenre = Genre.valueOf(token[4]); //taking the string value and making it an enum
				

				// Create new product based on the type read from the file - allows the "filter-by" functions to work
				switch (type) {
				case "CD":
					CDRecordProduct CDProduct = new CDRecordProduct(title, price, year, fileGenre);
					masterInventory.add(CDProduct);
					break;
				case "Vinyl":
					VinylRecordProduct VinylProduct = new VinylRecordProduct(title, price, year, fileGenre);
					masterInventory.add(VinylProduct);
					break;
				case "Tape":
					TapeRecordProduct TapeProduct = new TapeRecordProduct(title, price, year, fileGenre);
					masterInventory.add(TapeProduct);
					break;
				default: 
					System.out.println("Improper file format!");
					return false;
					
				}
				
				//masterInventory.add(new MediaProduct(title, price, year, fileGenre));
			}
			fileIn.close();
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
	public boolean removeItem(MediaProduct product) {
		if(masterInventory.remove(product)) {
			saveStock();
			return true;
		}
		return false;
	}
	// Save Stock
	public boolean saveStock(){
		try{ 
			FileWriter writer = new FileWriter(inventoryFilePath);
			writer.write("Type,Title,Price,Year,Genre\n");
			for(MediaProduct product : masterInventory) {
				String fullType = product.getClass().getSimpleName();
				
				
				// Hold the "cleaned" type
				String type;
				
				// Sets type based on the object type
				switch(fullType) {
				case "CDRecordProduct":
					type = "CD";
					break;
				case "VinylRecordProduct":
					type = "Vinyl";
					break;
				case "TapeRecordProduct":
					type = "Tape";
					break;
				default:
					System.out.println("Error in type conversion in saveStock - check switch");
					return false;
				}
				
																	// Concatenate the type with the printFormat output
				writer.write(type + "," + product.printFormat()); 	// printFormat contains the rest of the information in the expected formatting
			}
			writer.close();
			return true;
 		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * Returns an array list of products below the given maxPrice
	 */
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		ArrayList<MediaProduct> mediaList = new ArrayList<MediaProduct>();

		// Loop through all products in the inventory
		// Check if their price is less than the max price
		for(MediaProduct product : masterInventory) {
			if(product.getPrice() < maxPrice) {
				MediaProduct newProduct = new MediaProduct(product);
				mediaList.add(newProduct);
			}
		}
		return mediaList;
	}
	
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		// Loop through inv and update sought item
		for(MediaProduct item : masterInventory) {
			if(item.equals(product)) {
				item.setPrice(newPrice);
				return true;
			}
		}
		return false;
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
				VinylRecordProduct newProduct = new VinylRecordProduct((VinylRecordProduct)product);
				
				vinyls.add(newProduct);
			}
		}
		return vinyls;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		
		ArrayList<CDRecordProduct> cds = new ArrayList<>();
		for(MediaProduct product : productList){
			if(product instanceof CDRecordProduct){
				CDRecordProduct newProduct = new CDRecordProduct((CDRecordProduct)product);
				cds.add(newProduct);
			}
		}
		
		return cds;
		
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		ArrayList<TapeRecordProduct> tapes = new ArrayList<>();
		for(MediaProduct product : productList){
			if(product instanceof TapeRecordProduct){
				TapeRecordProduct newProduct = new TapeRecordProduct((TapeRecordProduct)product);
				tapes.add(newProduct);
			}
		}
		return tapes;
	}	
}

