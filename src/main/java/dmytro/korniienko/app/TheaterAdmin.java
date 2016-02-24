package dmytro.korniienko.app;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.AuditoriumService;
import dmytro.korniienko.service.BookingService;
import dmytro.korniienko.service.EventService;
import dmytro.korniienko.service.UserService;

@Component
public class TheaterAdmin {

	@Autowired
	private EventService eventService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private AuditoriumService auditoriumService;

	@Autowired
	private UserService userService;

	public Event createNewEvent(String name, Date date, Double price) {
		Event newEvent = new Event();
		newEvent.setName(name);
		newEvent.setDate(date);
		newEvent.setPrice(price);

		System.out.println("Created event : " + newEvent.getName());

		return newEvent;
	}

	public Auditorium addNewAuditorium(String name, int numberOfSeats, List<Integer> vipSeats) {
		Auditorium newPlace = new Auditorium("Royal Theatre", numberOfSeats, vipSeats);
		auditoriumService.createAuditorium(newPlace);
		System.out.println("Added new venue : " + newPlace.getName());
		return newPlace;
	}

	public void assignEventToAuditorium(Auditorium place, Event event) {
		event.setAuditorium(place);
		eventService.assignAuditorium(event, place, event.getDate());
		System.out.println(event.getName() + " will take place at " + place.getName());
	}

	public Map<String, Ticket> getBookedTickets(Event event) {
		return bookingService.getTicketsForEvent(event);
	}

	public double getTicketPrice(String eventName, User user, int seatNumber) {
		Event event = eventService.getByName(eventName);
		double ticketPrice = bookingService.assignTicketPrice(eventName, user,
				bookingService.getTicketByEventAndSeat(event, seatNumber));
		System.out.println("Price of ticket for " + eventName + " seat number " + seatNumber + " is : " + ticketPrice);
		return ticketPrice;
	}

	public User registerNewUser(User user) {
		userService.register(user);
		return user;
	}

}
