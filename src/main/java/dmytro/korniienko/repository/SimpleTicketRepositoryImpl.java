package dmytro.korniienko.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public class SimpleTicketRepositoryImpl implements TicketRepository {

	List<Ticket> tickets;
	
	public SimpleTicketRepositoryImpl(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	@Override
	public void bookTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	@Override
	public List<Ticket> getTicketsForEvent(Event event, Date date) {
		List<Ticket> ticketsForEvent = new ArrayList<>();
		for (Ticket ticket : tickets){
			if (ticket.getEvent().equals(event) && ticket.getTime().equals(date)){
				ticketsForEvent.add(ticket);
			}
		}
		return ticketsForEvent;
	}

	@Override
	public List<Ticket> getTicketsByUser(User user) {
		List<Ticket> usersTickets = new ArrayList<>();
		for (Ticket ticket : tickets){
			if (ticket.getUser().equals(user)){
				usersTickets.add(ticket);
			}
		}
		return usersTickets;
	}

}
