package dmytro.korniienko.entity;

import java.util.Calendar;
import java.util.List;

public class Auditorium {

	private String name;
	
	private List<Event> events;
	
	private int seats;
	
	private List<Integer> vipSeats;
	
	private List<Calendar> datesBooked;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event, Calendar date) {
		this.events.add(event);
		this.datesBooked.add(date);
	}

	public boolean checkDate(Calendar checkedDate){
		for (Calendar date : datesBooked){
			if (date.getTime() == checkedDate.getTime()){
				return false;
			}
		}
		return true;
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
