package dmytro.korniienko.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.service.AuditoriumService;
import dmytro.korniienko.service.BookingService;
import dmytro.korniienko.service.EventService;

public class TheaterAdmin {

	@Autowired
	EventService eventService;
	@Autowired
	BookingService bookingService;
	@Autowired
	AuditoriumService auditoriumService;

	public void createNewEvent(String name, Date date, Double price) {
		Event newEvent = new Event();
		List<Integer> vipSeats = new ArrayList<>();
		vipSeats.add(10);
		vipSeats.add(11);
		vipSeats.add(12);
		vipSeats.add(13);
		vipSeats.add(14);
		vipSeats.add(15);
		Auditorium newPlace = new Auditorium("Royal Theatre", 500, vipSeats);
		auditoriumService.createAuditorium(newPlace);
		newEvent.setName(name);
		newEvent.setDate(date);
		newEvent.setPrice(price);
		newEvent.setAuditorium(newPlace);
		eventService.assignAuditorium(newEvent, newPlace, date);
		System.out.println("Created event : " + newEvent.getName() + " at " + newEvent.getAuditorium().getName()
				+ " for " + newEvent.getAuditorium().getSeats() + " seats");
		System.out.println("Number of tickets available for " + newEvent.getName() + " = " + newEvent.getTickets().size());
	}

	public Map<String, Ticket> getBookedTickets(Event event) {
		return bookingService.getTicketsForEvent(event);
	}

}
