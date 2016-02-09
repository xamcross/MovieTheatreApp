package dmytro.korniienko.service;

import java.util.List;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface UserService {

	void register(User user);
	
	void remove(User user);
	
	User getById(long id);
	
	User getUserByEmail(String email);
	
	User getUserByName(String name);
	
	List<Ticket> getBookedTickets(User user);
	
}
