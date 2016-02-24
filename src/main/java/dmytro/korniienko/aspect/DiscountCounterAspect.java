package dmytro.korniienko.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DiscountCounterAspect {

	private static int totalDiscountsGiven = 0;

	@AfterReturning(pointcut = "execution(* dmytro.korniienko.service.DiscountService.getDiscount(..))", returning = "discountValue")
	public void countTotalDiscountsGiven(double discountValue) {
		if (discountValue > 0) {
			totalDiscountsGiven++;
			System.out.println("Total number of discounts given = " + totalDiscountsGiven);
		}
		else {
			System.out.println("This time no discount was given");
		}
	}

}
