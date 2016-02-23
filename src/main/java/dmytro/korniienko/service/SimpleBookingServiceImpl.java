package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.repository.TicketRepository;

public class SimpleBookingServiceImpl implements BookingService {
	
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	EventService eventService;

	@Autowired
	AuditoriumService auditoriumService;

	@Autowired
	DiscountService discountService;

	Ticket ticket;
	
	public SimpleBookingServiceImpl(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public double getTicketPrice(String eventName, Date date, List<Integer> seats, User user) {
		Event event = eventService.getByName(eventName);
		double totalPrice = 0.0;
		Auditorium place = event.getAuditorium();
		List<Integer> vipSeats = place.getVipSeats();
		for (int seatNum : seats) {
			double priceOfTicket = 0.0;
			if (vipSeats.contains(seatNum)) {
				priceOfTicket = event.getPrice() * 2;		
			} else {
				priceOfTicket = event.getPrice();
			}
			priceOfTicket = priceOfTicket * discountService.getDiscount(user, event, date, ticket);
			totalPrice += priceOfTicket;
		}
		return totalPrice;
	}

	@Override
	public void bookTicket(User user) {
		ticket.setUser(user);
		ticketRepository.bookTicket(ticket);
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

}
