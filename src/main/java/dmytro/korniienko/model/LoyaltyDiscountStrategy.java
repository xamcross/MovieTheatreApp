package dmytro.korniienko.model;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.service.BookingService;

public class LoyaltyDiscountStrategy extends DiscountStrategy {

	BookingService bookingService;
	
	public LoyaltyDiscountStrategy(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@Override
	public double calculateDiscount(User user, Event event, Date date, Ticket ticket) {
		double discountPercentage = 0.0;
		List<Ticket> ticketsByUser = bookingService.getByUser(user);
		if (ticketsByUser.indexOf(ticket) % 10 == 0){
			discountPercentage = 50;
		}

		return discountPercentage;
	}

}
