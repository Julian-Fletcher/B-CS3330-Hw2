package homework3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton 
{
	private static StockManagerSingleton instance = null;
	private final static String inventoryFilePath = "inventory.txt";
	
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
	
}

