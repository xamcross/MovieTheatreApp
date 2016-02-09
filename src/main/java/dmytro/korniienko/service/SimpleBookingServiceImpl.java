package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public class SimpleBookingServiceImpl implements BookingService {

	@Override
	public double getTicketPrice(Event event, Date date, Date time, List<Integer> seats, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void bookTicket(User user, Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ticket> getTicketsForEvent(Event event, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
