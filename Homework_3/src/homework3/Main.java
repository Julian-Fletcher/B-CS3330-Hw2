package homework3;
import java.util.ArrayList;

import mediaProducts.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("**** BEGIN TEST ****");
		
		
		
		// Create instance of stockManager
		StockManagerSingleton stockManagerSingleton = StockManagerSingleton.getInstance();
		
		// Error check stock init
		boolean initStock = stockManagerSingleton.initializeStock();
		if(initStock == true) {
			System.out.println("StockManagerSingleton initialized");
		}
		else {
			System.out.println("StockManagerSingleton did not initialize");
		}

		
		
		// List all items in the inventory
		System.out.println("\n\n**** PRINTING ORIGINAL INVENTORY ****");
		stockManagerSingleton.printListOfMediaProduct(stockManagerSingleton.masterInventory);
		
		
		//Get inventory size
		System.out.println("Original Inventory Size: " + stockManagerSingleton.masterInventory.size());
		
		
		// Get inventory items worth less than 20
		ArrayList<MediaProduct> filterList = stockManagerSingleton.getMediaProductBelowPrice(20);
		
		// Print list of items
		System.out.println("\n\n**** PRINTING ITEMS LESS THAN 20.00 ****");
		stockManagerSingleton.printListOfMediaProduct(filterList);
		
		// Creating products to be added to the inventory
		CDRecordProduct mediaProduct = new CDRecordProduct("test", 2000, 2020, Genre.POP);
		VinylRecordProduct mediaProduct2 = new VinylRecordProduct("JILLY BOP", .20, 2023, Genre.ELECTRONIC);
		TapeRecordProduct mediaProduct3 = new TapeRecordProduct("BobPainting", 52.65, 2000, Genre.CHILDREN);
		CDRecordProduct mediaProduct4 = new CDRecordProduct("Beets", -2, 1020, Genre.CLASSICAL);
		
		// Add media items to the inventory
		boolean add = stockManagerSingleton.addItem(mediaProduct);
		boolean add2 = stockManagerSingleton.addItem(mediaProduct2);
		boolean add3 = stockManagerSingleton.addItem(mediaProduct3);
		boolean add4 = stockManagerSingleton.addItem(mediaProduct4);
		
		// Error check adding items to inv
		if(add == false || add2 == false || add3 == false || add4 == false) {
			System.out.println("Unsucessful add");
			System.out.println("Results of adding items to the inventory: " + add + " " +  add2 + " " +  add3 + " " + add4);
		}
		else {
			System.out.println("Successful add: " + add + " " +  add2 + " " +  add3 + " " + add4);
		}
		

		// List all items in the inventory
		System.out.println("\n\n**** INVENTORY AFTER ADDING THINGS****");
		stockManagerSingleton.printListOfMediaProduct(stockManagerSingleton.masterInventory);
		
		// Get inventory size
		System.out.println("New Inventory Size: " + stockManagerSingleton.masterInventory.size());
		
		
		// Delete a newly added item from the inventory
		System.out.println("\n\n**** TESTING DELETE****");
		boolean del = stockManagerSingleton.removeItem(mediaProduct);
		boolean del2 = stockManagerSingleton.removeItem(mediaProduct2);
		if(del == true && del2 == true) {
			System.out.println("Delete successful");
		}
		else {
			System.out.println("Delete unsucessful");
		}
		
		
		
		// Update first inventory item price
		System.out.println("\n\n**** TESTING ITEM UPDATE****");
		boolean update = stockManagerSingleton.updateItemPrice(stockManagerSingleton.masterInventory.get(0), 1000);
		if(update == true) {
			System.out.println("Update successful");
		}
		else {
			System.out.println("Update unsucessful");
		}
		
		
		// List updated inventory
		System.out.println("\n\n**** INVENTORY AFTER DELETE AND UPDATE ****");
		stockManagerSingleton.printListOfMediaProduct(stockManagerSingleton.masterInventory);
		System.out.println("New Inventory Size: " + stockManagerSingleton.masterInventory.size());
		
		
		
		// Test save stock
		System.out.println("\n\n**** TESTING SAVE STOCK ****");
		boolean saveStock = stockManagerSingleton.saveStock();
		if(saveStock == true) {
			System.out.println("STOCK SAVED!");
		}
		else {
			System.out.println("STOCK NOT SAVED!");
		}
		
		
		
		// Clear the stock inv
		stockManagerSingleton.masterInventory.clear();
		
		// Re initialize the stock
		// Error check stock init
		boolean reInit = stockManagerSingleton.initializeStock();
		if(reInit == true) {
			System.out.println("StockManagerSingleton initialized");
		}
		else {
			System.out.println("StockManagerSingleton did not initialize");
		}
		
		// Print newly-loaded inventory
		System.out.println("\n\n*** NEW MASTER INVENTORY LOADED FROM FILE***");
		stockManagerSingleton.printListOfMediaProduct(stockManagerSingleton.masterInventory);
		System.out.println("New Inventory Size: " + stockManagerSingleton.masterInventory.size());
		
		
		System.out.println("\n\n**** TESTING PRODUCT FILTERS****");
		// Create CD inv list
		ArrayList<CDRecordProduct> cdInv = new ArrayList<>();
		// Create vinyl inv list
		ArrayList<VinylRecordProduct> vinylInv= new ArrayList<>();
		// Create tape inv list
		ArrayList<TapeRecordProduct> tapeInv = new ArrayList<>();
		
		
		// Get filtered lists
		vinylInv = stockManagerSingleton.getVinylRecordList(stockManagerSingleton.masterInventory);
		tapeInv = stockManagerSingleton.getTapeRecordList(stockManagerSingleton.masterInventory);
		cdInv = stockManagerSingleton.getCDRecordsList(stockManagerSingleton.masterInventory);
		
		// Generic list to hold filtered list
		ArrayList<MediaProduct> filteredList = new ArrayList<>();
		
		// Print filtered invs
		
		System.out.println(" ** PRINTING ALL CDs **");
		filteredList.addAll(cdInv);														// Add CD Filtered inv
		stockManagerSingleton.printListOfMediaProduct(filteredList);					// Print cd inv
		filteredList.clear();															// Remove all items
		System.out.println();
		
		
		System.out.println(" ** PRINTING ALL VINYLS **");
		filteredList.addAll(vinylInv);													// Add Vinyl Filtered inv
		stockManagerSingleton.printListOfMediaProduct(filteredList);					// Print vinyl inv
		filteredList.clear();															// Remove all items
		System.out.println();
		
		
		System.out.println(" ** PRINTING ALL TAPES **");
		filteredList.addAll(tapeInv);													// Add Tape Filtered inv
		stockManagerSingleton.printListOfMediaProduct(filteredList);					// Print tape inv
		filteredList.clear();															// Remove all items
		System.out.println();
		
		
		
	}

}
