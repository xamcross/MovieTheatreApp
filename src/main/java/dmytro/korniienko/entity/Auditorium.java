package dmytro.korniienko.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Auditorium {

	private String name;
	
	private List<Event> events;
	
	private int seats;
	
	private List<Integer> vipSeats;
	
	private List<Date> datesBooked;
	
	public Auditorium (String name, int seats, List<Integer> vipSeats){
		this.name = name;
		this.seats = seats;
		this.vipSeats = new ArrayList<>();
		this.vipSeats.addAll(vipSeats);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return events;
	}
	
	public List<Date> getDatesBooked(){
		return datesBooked;
	}
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public List<Integer> getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(List<Integer> vipSeats) {
		this.vipSeats = vipSeats;
	}
	
}
