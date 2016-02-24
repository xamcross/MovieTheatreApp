package dmytro.korniienko.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.repository.TicketRepository;

@Component
public class SimpleBookingServiceImpl implements BookingService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private EventService eventService;

	@Autowired
	private DiscountService discountService;

	@Override
	public double assignTicketPrice(String eventName, User user, Ticket ticket) {
		Event event = eventService.getByName(eventName);
		Auditorium place = event.getAuditorium();
		List<Integer> vipSeats = place.getVipSeats();
		
		double priceOfTicket = 0.0;

		if (vipSeats.contains(ticket.getSeatNumber())) {
			priceOfTicket = event.getPrice() * 2;
		} else {
			priceOfTicket = event.getPrice();
		}

		priceOfTicket -= priceOfTicket * discountService.getDiscount(user, event, ticket);

		ticket.setPrice(priceOfTicket);
		return priceOfTicket;
	}

	@Override
	public void bookTicket(User user, Ticket ticket) {
		assignTicketPrice(ticket.getEvent().getName(), user, ticket);
		ticket.setUser(user);
	}

	@Override
	public Map<String, Ticket> getTicketsForEvent(Event event) {
		return ticketRepository.getTicketsForEvent(event);
	}

	@Override
	public Map<String, Ticket> getByUser(User user) {
		return ticketRepository.getTicketsByUser(user);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.getTicketById(id);
	}

	@Override
	public void fillEventWithTickets(Event event) {
		if (event.getTickets().size() < event.getAuditorium().getSeats()) {
			System.out.println("This auditorium has " + event.getAuditorium().getSeats() + " seats");
			for (int ticketNumber = 0; ticketNumber < event.getAuditorium().getSeats(); ticketNumber++) {
				Ticket newTicket = new Ticket(event, ticketNumber);
				newTicket.setPrice(event.getPrice());
				event.getTickets().put(newTicket.toString(), newTicket);
				ticketRepository.createTicket(newTicket);
			}
		}
	}

	@Override
	public Ticket getTicketByEventAndSeat(Event event, int seatNumber) {
		Map<String,Ticket> tickets = ticketRepository.getTicketsForEvent(event);
		for (Ticket ticket : tickets.values()){
			if (ticket.getSeatNumber() == seatNumber){
				return ticket;
			}
		}
		return null;
	}

}
