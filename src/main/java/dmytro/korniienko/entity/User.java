package dmytro.korniienko.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {

	private Long id;
	
	private String name;
	
	private String email;
	
	private Date dateOfBirth = new Date(1);
	
	private Map<String, Ticket> bookedTickets = new HashMap<>();
	
	public User(){
		
	}
	
	public User(String name, String email){
		this.name = name;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Map<String, Ticket> getBookedTickets() {
		return bookedTickets;
	}

	public void setBookedTickets(Map<String, Ticket> bookedTickets) {
		this.bookedTickets = bookedTickets;
	}

}
