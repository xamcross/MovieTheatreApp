package dmytro.korniienko.service;

import java.util.Date;
import java.util.List;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.model.DiscountStrategy;

public class SimpleDiscountServiceImpl implements DiscountService {

	List<DiscountStrategy> strategies;
	
	public SimpleDiscountServiceImpl(List<DiscountStrategy> strategies) {
		this.strategies = strategies;
	}
	
	@Override
	public double getDiscount(User user, Event event, Date date, Ticket ticket) {
		double fullDiscount = 0.0;
		for (DiscountStrategy strategy : strategies){
			fullDiscount += strategy.calculateDiscount(user, event, date, ticket);
		}
		return fullDiscount;
	}

}
