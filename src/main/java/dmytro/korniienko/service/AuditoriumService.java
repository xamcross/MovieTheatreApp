package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public interface AuditoriumService {

	List<Auditorium> getAuditoriums();

	void assignAuditorium(Event event, Auditorium auditorium, Date date);
	
	Auditorium getAuditoriumByTime(Event event, Date time);
}
