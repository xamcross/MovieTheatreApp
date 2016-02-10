package dmytro.korniienko.repository;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface AuditoriumRepository {

	List<Auditorium> getAuditoriums();

	void addEvent(Event event, Auditorium auditorium, Date date);
	
	Auditorium getAuditoriumByTime(Event event, Date time);
}
