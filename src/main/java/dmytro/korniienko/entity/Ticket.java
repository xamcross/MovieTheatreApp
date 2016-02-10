package dmytro.korniienko.entity;

import java.util.Date;

public class Ticket {

	private long id;
	
	private Event event;
	
	private Date time;
	
	private int seatNumber;
	
	private User user;
	
	public Ticket(Event event, Date time, int seatNumber) {
		this.event = event;
		this.time = time;
		this.seatNumber = seatNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
