package dmytro.korniienko.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public class SimpleTicketRepositoryImpl implements TicketRepository {
	
	@Autowired
	Map<String, Ticket> tickets;

	@Override
	public void bookTicket(Ticket ticket) {
		tickets.put(ticket.toString(), ticket);
	}

	@Override
	public Map<String, Ticket> getTicketsForEvent(Event event) {
		Map<String, Ticket> ticketsForEvent = new HashMap<>();
		for (Ticket ticket : tickets.values()) {
			if (ticket.getEvent().equals(event)) {
				ticketsForEvent.put(ticket.toString(), ticket);
			}
		}
		return ticketsForEvent;
	}

	@Override
	public Map<String, Ticket> getTicketsByUser(User user) {
		Map<String, Ticket> usersTickets = new HashMap<>();
		for (Ticket ticket : tickets.values()) {
			if (ticket.getUser().equals(user)) {
				usersTickets.put(ticket.toString(), ticket);
			}
		}
		return usersTickets;
	}

	@Override
	public Ticket getTicketById(Long id) {
		for (Ticket ticket : tickets.values()){
			if (ticket.getId() == id){
				return ticket;
			}
		}
		return null;
	}

	@Override
	public void createTicket(Ticket ticket) {
		tickets.put(ticket.toString(), ticket);
	}

}
