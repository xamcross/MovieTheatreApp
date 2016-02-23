package dmytro.korniienko.repository;

import java.util.Map;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface AuditoriumRepository {

	Map<String, Auditorium> getAuditoriums();

	void addEvent(Event event, Auditorium auditorium);

	Auditorium getAuditoriumById(Long id);
	
	void createAuditorium(Auditorium place);
}
