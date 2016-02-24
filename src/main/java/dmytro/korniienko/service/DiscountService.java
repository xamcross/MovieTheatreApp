package dmytro.korniienko.service;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface DiscountService {

	double getDiscount(User user, Event event, Ticket ticket);
	
}
