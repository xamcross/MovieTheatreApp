package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.repository.AuditoriumRepository;

public class SimpleAuditoriumServiceImpl implements AuditoriumService {
	
	private AuditoriumRepository auditoriumRepository;
	
	public SimpleAuditoriumServiceImpl(AuditoriumRepository repo) {
		this.auditoriumRepository = repo;
	}
	
	@Override
	public List<Auditorium> getAuditoriums() {
		return auditoriumRepository.getAuditoriums();
	}

	@Override
	public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
		auditoriumRepository.addEvent(event, auditorium, date);
	}

	@Override
	public Auditorium getAuditoriumByTime(Event event, Date time) {
		return auditoriumRepository.getAuditoriumByTime(event, time);
	}
	
}
