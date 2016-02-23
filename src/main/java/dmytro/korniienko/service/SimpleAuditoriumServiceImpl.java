package dmytro.korniienko.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.repository.AuditoriumRepository;

public class SimpleAuditoriumServiceImpl implements AuditoriumService {

	@Autowired
	private AuditoriumRepository auditoriumRepository;

	@Override
	public Map<String, Auditorium> getAuditoriums() {
		return auditoriumRepository.getAuditoriums();
	}

	@Override
	public void assignAuditorium(Event event, Auditorium auditorium) {
		auditoriumRepository.addEvent(event, auditorium);
	}

	@Override
	public Auditorium getAuditoriumById(Long id) {
		return auditoriumRepository.getAuditoriumById(id);
	}

	@Override
	public void createAuditorium(Auditorium place) {
		auditoriumRepository.createAuditorium(place);
	}

}
