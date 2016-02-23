package dmytro.korniienko.service;

import java.util.Map;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface AuditoriumService {

	Map<String, Auditorium> getAuditoriums();

	void assignAuditorium(Event event, Auditorium auditorium);
	
	Auditorium getAuditoriumById(Long id);
}
