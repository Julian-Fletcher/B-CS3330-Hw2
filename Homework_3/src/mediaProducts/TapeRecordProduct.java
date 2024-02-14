package mediaProducts;

import homework3.Genre;

/*Subclass of MediaProduct*/
public class TapeRecordProduct extends MediaProduct {
	
	// Generic constructor
	public TapeRecordProduct() {
		super();
	}
	
	// Full constructor
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	// Copy constructor
	public TapeRecordProduct(TapeRecordProduct product) {
		this.genre = product.genre;
		this.price = product.price;
		this.year = product.year;
		this.title = product.title;
	}
}	
