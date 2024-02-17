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
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			String waste = fileIn.nextLine(); //assuming that the file element line is present
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
				
				masterInventory.add(new MediaProduct(title, price, year, fileGenre));
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
			for(MediaProduct product : masterInventory) 
			{
				writer.write(product.getTitle() + "," + product.getPrice() + "," + product.getYear() + "," + product.getGenre() + "\n");
			}
			writer.close();
			return true;
 		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
 // Method to get media products below a certain price
	public ArrayList<MediaProduct> getMediaProductBelowPrice(double maxPrice) {
		return InventoryFilter.getMediaProductBelowPrice(masterInventory, maxPrice);

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

