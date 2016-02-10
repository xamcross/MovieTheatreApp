package dmytro.korniienko.model;

import java.util.Date;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public class BirthdayDiscountStrategy extends DiscountStrategy {

	public BirthdayDiscountStrategy() {

	}

	@Override
	public double calculateDiscount(User user, Event event, Date date, Ticket ticket) {
		double discountPercentage = 0.0;
		if (user.getDateOfBirth().getTime() == new Date().getTime()){
			discountPercentage = 5;
		}
		return discountPercentage;
	}

}
