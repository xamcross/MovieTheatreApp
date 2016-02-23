package dmytro.korniienko.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.repository.AuditoriumRepository;

public class Launcher {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
			
		Auditorium place = (Auditorium)ctx.getBean("auditorium1");
		System.out.println(place.getName());
		
	}

}
