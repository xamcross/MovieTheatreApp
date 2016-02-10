package dmytro.korniienko.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public class SimpleEventRepositoryImpl implements EventRepository{

	List<Event> events;
	
	public SimpleEventRepositoryImpl(List<Event> events) {
		this.events = events;
	}
	
	@Override
	public void createEvent(Event event) {
		events.add(event);
	}

	@Override
	public void removeEvent(Event event) {
		events.remove(event);
		
	}

	@Override
	public Event getByName(String name) {
		for (Event event : events){
			if (event.getName().equals(name)){
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
	public List<Event> getForDateRange(Date from, Date to) {
		List<Event> eventsInRange = new ArrayList<>();
		for (Event event : events){
			for (Date date : event.getDate()){
				if (date.after(from) && date.before(to)){
					eventsInRange.add(event);
					break;
				}
			}
		}
		return eventsInRange;
	}

	@Override
	public List<Event> getNextEvents(Date to) {
		List<Event> eventsInRange = new ArrayList<>();
		for (Event event : events){
			for (Date date : event.getDate()){
				if (date.before(to)){
					eventsInRange.add(event);
					break;
				}
			}
		}
		return eventsInRange;
	}

}
