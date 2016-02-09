package dmytro.korniienko.service;

import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface AuditoriumService {

	List<Auditorium> getAuditoriums();
	
	List<Event> getAllEvents();
}
