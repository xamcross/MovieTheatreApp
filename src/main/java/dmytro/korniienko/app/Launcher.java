package dmytro.korniienko.app;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dmytro.korniienko.entity.Auditorium;

public class Launcher {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
			
		Auditorium place = (Auditorium)ctx.getBean("auditorium1");
		System.out.println(place.getName());
		
		TheaterAdmin admin = new TheaterAdmin();
		admin.createNewEvent("Rammstein tribute", new Date(), 5.99);
	}

}
