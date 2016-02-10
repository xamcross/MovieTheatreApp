package dmytro.korniienko.repository;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public class SimpleAuditoriumRepositoryImpl implements AuditoriumRepository {

	List<Auditorium> auditoriums;
	
	public SimpleAuditoriumRepositoryImpl(List<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}
	
	@Override
	public List<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	@Override
	public void addEvent(Event event, Auditorium auditorium, Date date) {
		for (Auditorium place : auditoriums){
			if (place.getName().equals(auditorium.getName())){
				place.getEvents().add(event);
				place.getDatesBooked().add(date);
			}
		}
	}

	@Override
	public Auditorium getAuditoriumByTime(Event event, Date time) {
		for (Auditorium place : auditoriums){
			if (place.getEvents().contains(event)){
				for (Date timeOfEvent : event.getDate()){
					if (timeOfEvent.equals(time)){
						return place;
					}
				}
			}
			else {
				continue;
			}
		}
		return null;
	}

}
