package dmytro.korniienko.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

@Component
public class SimpleAuditoriumRepositoryImpl implements AuditoriumRepository {
	
	@Autowired
	private Map<String, Auditorium> auditoriums;


	@Override
	public Map<String, Auditorium> getAuditoriums() {
		return auditoriums;
	}

	@Override
	public void addEvent(Event event, Auditorium auditorium) {
		auditorium.getEvents().put(event.toString(), event);
	}

	@Override
	public Auditorium getAuditoriumById(Long id) {
		for (Auditorium place : auditoriums.values()){
			if (place.getId() == id){
				return place;
			}
		}
		return null;
	}

	@Override
	public void createAuditorium(Auditorium place) {
		auditoriums.put(place.getName(), place);
	}

}
