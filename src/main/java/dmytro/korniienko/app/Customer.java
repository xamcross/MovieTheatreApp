package dmytro.korniienko.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.BookingService;
import dmytro.korniienko.service.UserService;

@Component
public class Customer {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService bookingService;
	
	public void bookTicketForUser(User user, Event event, int seatNumber){
		Ticket ticket = bookingService.getTicketByEventAndSeat(event, seatNumber);
		userService.bookTicket(user, ticket);
		System.out.println(user.getName() + " has just bought a ticket for " + event.getName() + " seat number = " + seatNumber + " for $" + ticket.getPrice());
	}
}
