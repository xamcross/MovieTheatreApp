package dmytro.korniienko.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.BookingService;

public class LoyaltyDiscountStrategy extends DiscountStrategy {

	@Autowired
	private BookingService bookingService;
	
	@Override
	public double calculateDiscount(User user, Event event, Ticket ticket) {
		double discountPercentage = 0.0;
		Map<String, Ticket> ticketsByUser = bookingService.getByUser(user);
		if (ticketsByUser.size() % 9 == 0 && ticketsByUser.size() > 0){
			discountPercentage = 0.5;
		}
		
		return discountPercentage;
	}
	
}
