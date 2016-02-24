package dmytro.korniienko.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.UserService;

@Component
public class Customer {

	@Autowired
	UserService userService;
	
	public void bookTicketForUser(User user, Ticket ticket){
		userService.bookTicket(user, ticket);
		
	}
}
