package dmytro.korniienko.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dmytro.korniienko.repository.AuditoriumRepository;

public class Launcher {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		AuditoriumRepository repo = (AuditoriumRepository) ctx.getBean("auditoriumRepository");
		repo.getAuditoriums();
	}

}
