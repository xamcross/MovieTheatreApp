package dmytro.korniienko.service;

import java.util.Date;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface DiscountService {

	double getDiscount(User user, Event event, Date date, Ticket ticket);
	
}
