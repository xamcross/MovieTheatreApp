package dmytro.korniienko.entity;

import java.util.Calendar;
import java.util.List;

public class Event {

	private String name;
	
	private double price;
	
	private Rating rating;
	
	private List<Calendar> date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Calendar> getDate() {
		return date;
	}

	public void setDate(List<Calendar> date) {
		this.date = date;
	}
	
}
