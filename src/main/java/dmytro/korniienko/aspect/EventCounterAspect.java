package dmytro.korniienko.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EventCounterAspect {

	private static int eventFinderCounter = 0;
 	
	@After("execution(dmytro.korniienko.entity.Event dmytro.korniienko.service.EventService.getByName(..))")
	public void countNumberOfExecutions(){
		eventFinderCounter++;
		System.out.println("Events have been looked for " + eventFinderCounter + " times");
	}
	
	
}
