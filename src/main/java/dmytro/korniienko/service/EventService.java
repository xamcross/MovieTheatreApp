package dmytro.korniienko.service;

import java.util.Date;
import java.util.Map;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface EventService {

	void create(Event event);
	
	void remove(Event event);
	
	Event getByName(String name);
	
	Map<String, Event> getAll();
	
	Map<String, Event> getForDateRange(Date from, Date to);
	
	Map<String, Event> getNextEvents(Date to);
	
	void assignAuditorium(Event event, Auditorium auditorium, Date date);
	
	Event getEventById(Long id);
	
}
