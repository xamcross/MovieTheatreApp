package dmytro.korniienko.service;

import java.util.Calendar;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface EventService {

	void create(Event event);
	
	void remove(Event event);
	
	Event getByName(String name);
	
	List<Event> getAll();
	
	List<Event> getForDateRange(Calendar from, Calendar to);
	
	List<Event> getNextEvents(Calendar to);
	
	void assignAuditorium(Event event, Auditorium auditorium, Calendar date);
	
}
