package dmytro.korniienko.entity;

public class Ticket implements Comparable<Ticket>{

	private Long id;
	
	private Event event;
	
	private int seatNumber;
	
	private User user;
	
	private double price;
	
	public Ticket(Event event, int seatNumber) {
		this.event = event;
		this.seatNumber = seatNumber;
		this.price = event.getPrice();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public String toString(){
		return "Event : " + this.event + "\nSeat : " + this.seatNumber + "\nTime : ";
	}

	@Override
	public int compareTo(Ticket o) {
		return (int) (event.getDate().getTime() - o.getEvent().getDate().getTime());
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
