package dmytro.korniienko.service;

import java.util.Calendar;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public class SimpleEventServiceImpl implements EventService {

	List<Event> events;
	
	List<Auditorium> auditoriums;
	
	private AuditoriumService auditoriumService;

	@Override
	public void create(Event event) {
		events.add(event);
	}

	@Override
	public void remove(Event event) {
		events.remove(event);
	}

	@Override
	public Event getByName(String name) {
		for (Event event : events) {
			if (event.getName().equals(name)) {
				return event;
			}
		}
		return null;
	}

	@Override
	public List<Event> getAll() {
		return events;
	}

	@Override
	public List<Event> getForDateRange(Calendar from, Calendar to) {
		
		return null;
	}

	@Override
	public List<Event> getNextEvents(Calendar to) {
		
		return null;
	}

	@Override
	public void assignAuditorium(Event event, Auditorium auditorium, Calendar date) {
		
	}

}
