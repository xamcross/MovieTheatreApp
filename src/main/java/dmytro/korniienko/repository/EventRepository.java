package dmytro.korniienko.repository;

import java.util.Date;
import java.util.Map;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface EventRepository {

	void createEvent(Event event);

	void removeEvent(Event event);

	Event getByName(String name);

	Map<String, Event> getAll();

	Map<String, Event> getForDateRange(Date from, Date to);

	Map<String, Event> getNextEvents(Date to);
	
	Event getEventById(Long id);
	
	Map<String, Event> getEventsForAuditorium(Auditorium place);

}
