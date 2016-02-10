package dmytro.korniienko.model;

import java.util.Date;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

public abstract class DiscountStrategy {

	public abstract double calculateDiscount(User user, Event event, Date date, Ticket ticket);

}
