package homework3;
import mediaProducts.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Epic cool test code!");
		
		MediaProduct mediaProduct = new MediaProduct("test", 2000, 2020, Genre.POP);
		MediaProduct mediaProduct2 = new MediaProduct("JILLY BOP", .20, 2023, Genre.ELECTRONIC);
		MediaProduct mediaProduct3 = new MediaProduct("BobPainting", 52.65, 2000, Genre.CHILDREN);
		MediaProduct mediaProduct4 = new MediaProduct("Beets", -2, 1020, Genre.CLASSICAL);
		//System.out.println("Test Media Product toString():\n" + mediaProduct.toString());
		
		StockManagerSingleton stockManagerSingleton = StockManagerSingleton.getInstance();
		
		boolean add = stockManagerSingleton.addItem(mediaProduct);
		boolean add2 = stockManagerSingleton.addItem(mediaProduct2);
		boolean add3 = stockManagerSingleton.addItem(mediaProduct3);
		boolean add4 = stockManagerSingleton.addItem(mediaProduct4);
		
		
		
		System.out.println(stockManagerSingleton.getVinylRecordList(stockManagerSingleton.masterInventory));
		System.out.println(stockManagerSingleton.getTapeRecordList(stockManagerSingleton.masterInventory));
		System.out.println(stockManagerSingleton.getCDRecordsList(stockManagerSingleton.masterInventory));
		
		System.out.println("Results: " + add + " " +  add2 + " " +  add3 + " " + add4);
		
		stockManagerSingleton.initializeStock();
		
		stockManagerSingleton.printListOfMediaProduct(stockManagerSingleton.masterInventory);
		
		
		
		
	}

}
