package dmytro.korniienko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;
import dmytro.korniienko.model.DiscountStrategy;

@Component
public class SimpleDiscountServiceImpl implements DiscountService {
	
	@Autowired
	private List<DiscountStrategy> strategies;

	@Override
	public double getDiscount(User user, Event event, Ticket ticket) {
		double fullDiscount = 0.0;
		for (DiscountStrategy strategy : strategies){
			fullDiscount += strategy.calculateDiscount(user, event, ticket);
		}
		return fullDiscount < 1 ? fullDiscount : 1;
	}

}
