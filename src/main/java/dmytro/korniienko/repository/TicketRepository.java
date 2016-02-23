package dmytro.korniienko.repository;

import java.util.Map;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface TicketRepository {

	void bookTicket(Ticket ticket);

	Map<String, Ticket> getTicketsForEvent(Event event);

	Map<String, Ticket> getTicketsByUser(User user);

	Ticket getTicketById(Long id);
	
	void createTicket(Ticket ticket);
}
