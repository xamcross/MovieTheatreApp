package dmytro.korniienko.service;

import java.io.File;
import java.util.List;

import dmytro.korniienko.entity.Auditorium;

public interface AuditoriumService {

	List<Auditorium> getAuditoriums(File path);
	
	int getSeatsNumber(Auditorium auditorium);
	
	List<Integer> getVipSeats(Auditorium auditorium);
	
}
