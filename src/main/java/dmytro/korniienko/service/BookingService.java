package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface BookingService {

	double getTicketPrice(String eventName, Date date, List<Integer> seats, User user);
	
	void bookTicket(User user);
	
	List<Ticket> getTicketsForEvent(Event event, Date date);

	List<Ticket> getByUser(User user);
	
}
