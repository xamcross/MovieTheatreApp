package dmytro.korniienko.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.BookingService;

public class LoyaltyDiscountStrategy extends DiscountStrategy {

	@Autowired
	BookingService bookingService;
	
	public LoyaltyDiscountStrategy() {
		
	}

	public void setBookingService(BookingService bookingService){
		this.bookingService = bookingService;
	}
	
	@Override
	public double calculateDiscount(User user, Event event, Date date, Ticket ticket) {
		double discountPercentage = 0.0;
		Map<String, Ticket> ticketsByUser = bookingService.getByUser(user);
		List<Ticket> ticketsList = new ArrayList<Ticket>(ticketsByUser.values());
		Collections.sort(ticketsList);
		if (ticketsList.indexOf(ticket) % 10 == 0){
			discountPercentage = 0.5;
		}

		return discountPercentage;
	}
	
}
