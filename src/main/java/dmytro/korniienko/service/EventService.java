package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface EventService {

	void create(Event event);
	
	void remove(Event event);
	
	Event getByName(String name);
	
	List<Event> getAll();
	
	List<Event> getForDateRange(Date from, Date to);
	
	List<Event> getNextEvents(Date to);
	
	void assignAuditorium(Event event, Auditorium auditorium, Date date);
	
}
