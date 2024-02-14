package mediaProducts;

import homework3.Genre;


/*Subclass of MediaProduct*/
public class VinylRecordProduct extends MediaProduct {
	
	// Generic constructor
	public VinylRecordProduct() {
		super();

	}

	// Full Constructor
	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);

	}
	
	// Copy Constructor
	public VinylRecordProduct(VinylRecordProduct product) {
		this.genre = product.genre;
		this.price = product.price;
		this.title = product.title;
		this.year = product.year;
	}

}
