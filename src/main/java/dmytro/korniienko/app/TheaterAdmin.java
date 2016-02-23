package dmytro.korniienko.app;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.service.BookingService;
import dmytro.korniienko.service.EventService;

public class TheaterAdmin {
	
	@Autowired
	EventService eventService;
	@Autowired
	BookingService bookingService;

	public void createNewEvent(String name, Date date, Double price){
		Event newEvent = new Event();
		newEvent.setName(name);
		newEvent.setDate(date);
		newEvent.setPrice(price);
		eventService.create(newEvent);
	}
	
	public Map<String, Ticket> getBookedTickets(Event event){
		return bookingService.getTicketsForEvent(event);
	}
	
}
