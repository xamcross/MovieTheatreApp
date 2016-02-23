package dmytro.korniienko.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.repository.EventRepository;

public class SimpleEventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private AuditoriumService auditoriumService;

	
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
	public Map<String, Event> getAll() {
		return eventRepository.getAll();
	}

	@Override
	public Map<String, Event> getForDateRange(Date from, Date to) {
		return eventRepository.getForDateRange(from, to);
	}

	@Override
	public Map<String, Event> getNextEvents(Date to) {
		return eventRepository.getNextEvents(to);
	}

	@Override
	public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
		event.setDate(date);
		event.setAuditorium(auditorium);
		eventRepository.createEvent(event);
		auditoriumService.assignAuditorium(event, auditorium);
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepository.getEventById(id);
	}

	@Override
	public Map<String, Event> getEventsByAuditorium(Auditorium place) {
		return eventRepository.getEventsForAuditorium(place);
	}

}
