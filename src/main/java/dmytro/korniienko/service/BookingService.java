package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface BookingService {

	double getTicketPrice(String eventName, Date date, List<Integer> seats, User user);
	
	void bookTicket(User user);
	
	Map<String, Ticket> getTicketsForEvent(Event event);

	Map<String, Ticket> getByUser(User user);
	
	Ticket getTicketById(Long id);
}
