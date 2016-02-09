package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface BookingService {

	double getTicketPrice(Event event, Date date, Date time, List<Integer> seats, User user);
	
	void bookTicket(User user, Ticket ticket);
	
	List<Ticket> getTicketsForEvent(Event event, Date date);
	
}
