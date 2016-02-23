package dmytro.korniienko.entity;

import java.util.Date;
import java.util.Map;

public class Event {

	private Long id;
	
	private String name;
	
	private double price;
	
	private Rating rating;
	
	private Date date;
	
	private Auditorium auditorium;
	
	private Map<String, Ticket> tickets;

	public Long getId(){
		return id;
	}
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public Map<String, Ticket> getTickets() {
		return tickets;
	}
	
}
