package dmytro.korniienko.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

public class Auditorium {

	private Long id;
	
	private String name;
	
	private Map<String, Event> events;
	
	private int numOfSeats;

	private List<Integer> vipSeats;
	
	public Auditorium(){
		
	}
	
	public Auditorium (String name, int seats, List<Integer> vipSeats){
		this.name = name;
		this.numOfSeats = seats;
		this.vipSeats = new ArrayList<>();
		this.vipSeats.addAll(vipSeats);
		this.events = new HashMap<>();
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Event> getEvents() {
		return events;
	}

	public int getSeats() {
		return numOfSeats;
	}

	public void setSeats(int seats) {
		this.numOfSeats = seats;
	}

	public List<Integer> getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(List<Integer> vipSeats) {
		this.vipSeats = vipSeats;
	}
	
}
