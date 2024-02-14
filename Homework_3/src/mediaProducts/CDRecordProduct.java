package mediaProducts;

import homework3.Genre;


/* Subclass of MediaProduct*/

public class CDRecordProduct extends MediaProduct {
	
	// Generic constructor
	public CDRecordProduct() {
		super();
	}
	
	// Full constructor
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	// Copy constructor
	public CDRecordProduct(CDRecordProduct product) {
		this.genre = product.genre;
		this.price = product.price;
		this.year = product.year;
		this.title = product.title;
	}
}
