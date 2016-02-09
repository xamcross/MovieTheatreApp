package dmytro.korniienko.service;

import java.util.ArrayList;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;

public class SimpleAuditoriumServiceImpl implements AuditoriumService {

	private List<Auditorium> auditoriums;
	
	public SimpleAuditoriumServiceImpl(List<Auditorium> auditoriums) {
		this.auditoriums = new ArrayList<>();
		this.auditoriums.addAll(auditoriums);
	}
	
	@Override
	public List<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
