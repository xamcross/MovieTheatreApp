package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.repository.EventRepository;

public class SimpleEventServiceImpl implements EventService {
	
	private EventRepository eventRepository;

	private AuditoriumService auditoriumService;
	
	public SimpleEventServiceImpl(EventRepository repo, AuditoriumService service) {
		this.eventRepository = repo;
		this.auditoriumService = service;
	}
	
	@Override
	public void create(Event event) {
		eventRepository.createEvent(event);
	}

	@Override
	public void remove(Event event) {
		eventRepository.removeEvent(event);
	}

	@Override
	public Event getByName(String name) {
		return eventRepository.getByName(name);
	}

	@Override
	public List<Event> getAll() {
		return eventRepository.getAll();
	}

	@Override
	public List<Event> getForDateRange(Date from, Date to) {
		return eventRepository.getForDateRange(from, to);
	}

	@Override
	public List<Event> getNextEvents(Date to) {
		return eventRepository.getNextEvents(to);
	}

	@Override
	public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
		event.getDate().add(date);
		event.getAuditoriums().add(auditorium);
		eventRepository.createEvent(event);
		auditoriumService.assignAuditorium(event, auditorium, date);
	}

}
