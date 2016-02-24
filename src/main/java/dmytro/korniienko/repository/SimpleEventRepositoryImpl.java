package dmytro.korniienko.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

@Component
public class SimpleEventRepositoryImpl implements EventRepository {

	@Autowired
	private Map<String, Event> events;

	public SimpleEventRepositoryImpl(){

	}
	
	@Override
	public void createEvent(Event event) {
		events.put(event.getName(), event);
	}

	@Override
	public void removeEvent(Event event) {
		events.remove(event);

	}

	@Override
	public Event getByName(String name) {
		for (Event event : events.values()) {
			if (event.getName().equals(name)) {
				return event;
			}
		}
		return null;
	}

	@Override
	public Map<String, Event> getAll() {
		return events;
	}

	@Override
	public Map<String, Event> getForDateRange(Date from, Date to) {
		Map<String, Event> eventsInRange = new HashMap<>();
		for (Event event : events.values()) {
			if ((event.getDate().after(from)) && (event.getDate().before(to))) {
				eventsInRange.put(event.toString(), event);
			}
		}
		return eventsInRange;
	}

	@Override
	public Map<String, Event> getNextEvents(Date to) {
		Map<String, Event> eventsInRange = new HashMap<>();
		for (Event event : events.values()) {
			if (event.getDate().before(to)) {
				eventsInRange.put(event.toString(), event);
				break;
			}

		}
		return eventsInRange;
	}

	@Override
	public Event getEventById(Long id) {
		for (Event event : events.values()) {
			if (event.getId() == id) {
				return event;
			}
		}
		return null;
	}

	@Override
	public Map<String, Event> getEventsForAuditorium(Auditorium place) {
		Map<String, Event> eventsOnStage = new HashMap<>();
		for (Event event : events.values()) {
			if (event.getAuditorium().equals(place)) {
				eventsOnStage.put(event.toString(), event);
			}
		}
		return eventsOnStage;
	}

}
