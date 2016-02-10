package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.repository.TicketRepository;

public class SimpleBookingServiceImpl implements BookingService {
	
	TicketRepository ticketRepository;

	EventService eventService;

	AuditoriumService auditoriumService;

	DiscountService discountService;

	Ticket ticket;
	
	public SimpleBookingServiceImpl(TicketRepository repo, EventService eventService,
			AuditoriumService auditoriumService, DiscountService discountService, Ticket ticket) {
		this.ticketRepository = repo;
		this.eventService = eventService;
		this.auditoriumService = auditoriumService;
		this.discountService = discountService;
		this.ticket = ticket;
	}

	@Override
	public double getTicketPrice(String eventName, Date date, List<Integer> seats, User user) {
		Event event = eventService.getByName(eventName);
		double totalPrice = 0.0;
		Auditorium place = auditoriumService.getAuditoriumByTime(event, date);
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
	public List<Ticket> getTicketsForEvent(Event event, Date date) {
		return ticketRepository.getTicketsForEvent(event, date);
	}

	@Override
	public List<Ticket> getByUser(User user) {
		return ticketRepository.getTicketsByUser(user);
	}

}
