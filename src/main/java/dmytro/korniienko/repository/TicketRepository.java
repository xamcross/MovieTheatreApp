package dmytro.korniienko.repository;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public interface TicketRepository {

	void bookTicket(Ticket ticket);

	List<Ticket> getTicketsForEvent(Event event, Date date);

	List<Ticket> getTicketsByUser(User user);
	
}
