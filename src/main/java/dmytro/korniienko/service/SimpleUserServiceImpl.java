package dmytro.korniienko.service;

import java.util.List;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.repository.UserRepository;

public class SimpleUserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private BookingService bookingService;

	public SimpleUserServiceImpl(UserRepository userRepository, BookingService bookingService) {
		this.userRepository = userRepository;
		this.bookingService = bookingService;
	}

	@Override
	public void register(User user) {
		userRepository.register(user);
	}

	@Override
	public void remove(User user) {
		userRepository.remove(user);
	}

	@Override
	public User getById(long id) {
		return userRepository.getById(id);
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
	public List<Ticket> getBookedTickets(User user) {
		
		return bookingService.getByUser(user);
	}

}
