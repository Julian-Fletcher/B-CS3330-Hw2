package mediaProducts;

import homework3.Genre;

/* Subclass of MediaProduct*/

public class MediaProductBelowPrice extends MediaProduct {
	
	// Generic constructor
	public MediaProductBelowPrice() {
		super();
	}
	
	// Full constructor
	public MediaProductBelowPrice(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	// Copy constructor
	public MediaProductBelowPrice(MediaProductBelowPrice product) {
		this.genre = product.genre;
		this.price = product.price;
		this.year = product.year;
		this.title = product.title;
	}
}
