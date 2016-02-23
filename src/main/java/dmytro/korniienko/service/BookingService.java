package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface BookingService {

	double assignTicketPrice(String eventName, Date date, User user, Ticket ticket);
	
	void bookTicket(User user, Ticket ticket);
	
	Map<String, Ticket> getTicketsForEvent(Event event);

	Map<String, Ticket> getByUser(User user);
	
	Ticket getTicketById(Long id);
	
	void fillEventWithTickets(Event event);
	
	Ticket getTicketByEventAndSeat(Event event, int seatNumber);
}
