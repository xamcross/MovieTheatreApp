package dmytro.korniienko.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.repository.UserRepository;

@Component
public class SimpleUserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingService bookingService;


	@Override
	public void register(User user) {
		userRepository.register(user);
	}

	@Override
	public void remove(User user) {
		userRepository.remove(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	@Override
	public User getUserByName(String name) {

		return userRepository.getByName(name);
	}

	@Override
	public Map<String, Ticket> getBookedTickets(User user) {
		
		return bookingService.getByUser(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public void bookTicket(User user, Ticket ticket) {
		user.getBookedTickets().put(ticket.toString(), ticket);
		bookingService.bookTicket(user, ticket);
	}


}
