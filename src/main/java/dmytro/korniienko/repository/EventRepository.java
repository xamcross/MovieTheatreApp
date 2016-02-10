package dmytro.korniienko.repository;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface EventRepository {
	
	void createEvent(Event event);
	
	void removeEvent(Event event);
	
	Event getByName(String name);
	
	List<Event> getAll();
	
	List<Event> getForDateRange(Date from, Date to);
	
	List<Event> getNextEvents(Date to);
	
}
