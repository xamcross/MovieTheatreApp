package dmytro.korniienko.service;

import java.util.ArrayList;
import java.util.List;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public class SimpleUserServiceImpl implements UserService {

	List<User> users;
	
	List<Ticket> tickets;
	
	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public void remove(User user) {
		users.remove(user);
	}

	@Override
	public User getById(long id) {
		for(User user : users){
			if (user.getId() == id){
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		for(User user : users){
			if (user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByName(String name) {
		for(User user : users){
			if (user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}

	@Override
	public List<Ticket> getBookedTickets(User user) {
		List<Ticket> bookedTickets = new ArrayList<>();
		for (Ticket ticket : tickets){
			if (ticket.getUser().equals(user)){
				bookedTickets.add(ticket);
			}
		}
		return bookedTickets;
	}

}
