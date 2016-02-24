package dmytro.korniienko.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dmytro.korniienko.entity.Auditorium;
import dmytro.korniienko.entity.Event;
import dmytro.korniienko.entity.User;

public class Launcher {

	private static final int DUMMY_SEAT_NUMBER_VIP = 12;
	private static final int DUMMY_SEAT_NUMBER_REGULAR = 22;
	private static final double DUMMY_EVENT_TICKET_PRICE = 5.99;
	private static final String DUMMY_EVENT_NAME = "Rammstein tribute";
	private static final String DUMMY_HALL_NAME = "Royal Hall";
	private static final int DUMMY_HALL_CAPACITY = 450;
	private static final String DUMMY_USER_NAME = "Vasiliy";
	private static final String DUMMY_USER_EMAIL = "vasvas@mail.com";
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		
		TheaterAdmin admin = (TheaterAdmin)ctx.getBean("theaterAdmin");
		Event newEvent = admin.createNewEvent(DUMMY_EVENT_NAME, new Date(), DUMMY_EVENT_TICKET_PRICE);
		
		List<Integer> vipSeats = new ArrayList<>();
		vipSeats.add(10);
		vipSeats.add(11);
		vipSeats.add(12);
		vipSeats.add(13);
		vipSeats.add(14);
		vipSeats.add(15);
		Auditorium royalHall = admin.addNewAuditorium(DUMMY_HALL_NAME, DUMMY_HALL_CAPACITY, vipSeats);
		
		admin.assignEventToAuditorium(royalHall, newEvent);
		
		User vasiliy = admin.registerNewUser(new User(DUMMY_USER_NAME, DUMMY_USER_EMAIL));
		admin.getTicketPrice(newEvent.getName(), vasiliy, DUMMY_SEAT_NUMBER_VIP);
		
		Customer customer = (Customer) ctx.getBean("customer");
		customer.bookTicketForUser(vasiliy, newEvent, DUMMY_SEAT_NUMBER_VIP);
		customer.bookTicketForUser(vasiliy, newEvent, DUMMY_SEAT_NUMBER_REGULAR);
		
		for (int i = 0; i < 25; i++){
			customer.bookTicketForUser(vasiliy, newEvent, 25 + i);
		}
		
		ctx.close();
	}

}
