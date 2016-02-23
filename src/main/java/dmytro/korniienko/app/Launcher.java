package dmytro.korniienko.app;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.User;

public class Launcher {

	private static final int DUMMY_SEAT_NUMBER_VIP = 12;
	private static final double DUMMY_EVENT_TICKET_PRICE = 5.99;
	private static final String DUMMY_EVENT_NAME = "Rammstein tribute";
	private static final String DUMMY_USER_NAME = "Vasiliy";
	private static final String DUMMY_USER_EMAIL = "vasvas@mail.com";
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		
		TheaterAdmin admin = (TheaterAdmin)ctx.getBean("theaterAdmin");
		Event newEvent = admin.createNewEvent(DUMMY_EVENT_NAME, new Date(), DUMMY_EVENT_TICKET_PRICE);
		
		User vasiliy = admin.registerNewUser(new User(DUMMY_USER_NAME, DUMMY_USER_EMAIL));
		admin.getTicketPrice(newEvent.getName(), newEvent.getDate(), vasiliy, DUMMY_SEAT_NUMBER_VIP);
		ctx.close();
	}

}
