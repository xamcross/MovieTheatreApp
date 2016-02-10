package dmytro.korniienko.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.service.BookingService;
import dmytro.korniienko.service.EventService;

public class TheaterAdmin {

	EventService eventService;
	BookingService bookingService;
	
	public TheaterAdmin(EventService eventService, BookingService bookingService){
		this.eventService = eventService;
		this.bookingService = bookingService;
	}
	
	public void createNewEvent(String name, Date date, Double price){
		Event newEvent = new Event();
		newEvent.setName(name);
		List<Date> dates = new ArrayList<Date>();
		dates.add(date);
		newEvent.setDate(dates);
		newEvent.setPrice(price);
		eventService.create(newEvent);
	}
	
	public List<Ticket> getBookedTickets(Event event, Date date){
		return bookingService.getTicketsForEvent(event, date);
	}
	
}
