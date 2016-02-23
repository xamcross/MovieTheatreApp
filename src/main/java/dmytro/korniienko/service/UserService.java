package dmytro.korniienko.service;

import java.util.Map;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface UserService {

	void register(User user);
	
	void remove(User user);
	
	User getUserByEmail(String email);
	
	User getUserByName(String name);
	
	Map<String, Ticket> getBookedTickets(User user);
	
	User getUserById(Long id);
}
