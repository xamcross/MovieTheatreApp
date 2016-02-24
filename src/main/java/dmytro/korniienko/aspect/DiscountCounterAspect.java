package dmytro.korniienko.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.Ticket;
import dmytro.korniienko.entity.User;

@Component
@Aspect
public class DiscountCounterAspect {

	private static int totalDiscountsGiven = 0;

	private static Map<String, Integer> usersDiscounts = new HashMap<>();

	@Pointcut("execution(* dmytro.korniienko.service.DiscountService.getDiscount(dmytro.korniienko.entity.User, dmytro.korniienko.entity.Event, dmytro.korniienko.entity.Ticket)) && args(user, event, ticket)")
	public void discountsGiven(User user, Event event, Ticket ticket) {
	}

	@AfterReturning(pointcut = "discountsGiven(user, event, ticket)", returning = "discountValue")
	public void countDiscountsGiven(double discountValue, User user, Event event, Ticket ticket) {
		if (discountValue > 0) {
			totalDiscountsGiven++;
			int discounts = 0;
			if (usersDiscounts.get(user.getName()) != null) {
				discounts = usersDiscounts.get(user.getName());
			}
			discounts++;
			usersDiscounts.put(user.getName(), discounts);
			System.out.println("Total number of discounts given = " + totalDiscountsGiven);
			System.out.println("Discounts received by user = " + discounts);
		} else {
			System.out.println("This time no discount was given");
		}
	}

}
