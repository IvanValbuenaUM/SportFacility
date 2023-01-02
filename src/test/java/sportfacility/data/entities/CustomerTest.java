package sportfacility.data.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import sportfacility.data.entities.facilities.Facility;

class CustomerTest {

	@Test
	void constructorTest() 
	{
		new Customer("Albert", "Omen", 20, "123456V", 1234);
	}
	
	@Test
	void zeroAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 0, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void negativeAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidIdMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "1123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}
	
	@Test
	void invalidIdLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}
	
	@Test
	void invalidIdNotNumberTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "a23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at position 0 must be a digit)"));
	}
	
	@Test
	void invalidIdNotLetterTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "1234567", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at last position must be a letter)"));
	}
	
	@Test
	void invalidMembershipNumberLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "123456V", -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect length)"));
	}
	
	@Test
	void invalidMembershipNumberMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "123456V", 10000)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect length)"));
	}
	
	@Test
	void getNameTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Albert", a.getName());
	}
	
	@Test
	void getSurnameTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Omen", a.getSurname());
	}
	
	@Test
	void getAgeTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(20, a.getAge());
	}
	
	@Test
	void getIdTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("123456V", a.getId());
	}
	
	@Test
	void getMembershipNumberTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(1234, a.getMembershipNumber());
	}
	
	@Test
	void nullNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer(null, "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer name is incorrect"));
	}
	
	@Test
	void blankNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("   ", "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer name is incorrect"));
	}
	
	@Test
	void nullSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", null, 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer surname is incorrect"));
	}
	
	@Test
	void blankSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "   ", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer surname is incorrect"));
	}
	
	@Test
	void nullIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, null, 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer id null"));
	}
	
	@Test
	void blankIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "   ", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}
	
	@Test
	void addReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		closedDays.put(Days.MONDAY, 0);
		closedDays.put(Days.MONDAY, 6);
		closedDays.put(Days.TUESDAY, 0);
		closedDays.put(Days.TUESDAY, 6);
		closedDays.put(Days.WEDNESDAY, 0);
		closedDays.put(Days.WEDNESDAY, 6);
		closedDays.put(Days.THURSDAY, 0);
		closedDays.put(Days.THURSDAY, 6);
		closedDays.put(Days.FRIDAY, 0);
		closedDays.put(Days.FRIDAY, 6);
		closedDays.put(Days.SATURDAY, 0);
		closedDays.put(Days.SATURDAY, 6);
		closedDays.put(Days.SUNDAY, -1);
		Facility f = new Facility("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable(s,e,a,f,3);
		
		a.addReservation(t);

		assertEquals(t, a.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		        	   a.addReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't add a null reservation"));
	}
	
	@Test
	void removeReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		        	   a.removeReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't remove a null reservation"));

	}
	
	@Test
	void removeReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		closedDays.put(Days.MONDAY, 0);
		closedDays.put(Days.MONDAY, 6);
		closedDays.put(Days.TUESDAY, 0);
		closedDays.put(Days.TUESDAY, 6);
		closedDays.put(Days.WEDNESDAY, 0);
		closedDays.put(Days.WEDNESDAY, 6);
		closedDays.put(Days.THURSDAY, 0);
		closedDays.put(Days.THURSDAY, 6);
		closedDays.put(Days.FRIDAY, 0);
		closedDays.put(Days.FRIDAY, 6);
		closedDays.put(Days.SATURDAY, 0);
		closedDays.put(Days.SATURDAY, 6);
		closedDays.put(Days.SUNDAY, -1);
		Facility f = new Facility("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable(s,e,a,f,3);
		
		a.addReservation(t);

		assertTrue(a.removeReservation(t));
		assertTrue(a.getReservations().size() == 0);
	}
	
	@Test
	void removeReservationNotFoundTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		closedDays.put(Days.MONDAY, 0);
		closedDays.put(Days.MONDAY, 6);
		closedDays.put(Days.TUESDAY, 0);
		closedDays.put(Days.TUESDAY, 6);
		closedDays.put(Days.WEDNESDAY, 0);
		closedDays.put(Days.WEDNESDAY, 6);
		closedDays.put(Days.THURSDAY, 0);
		closedDays.put(Days.THURSDAY, 6);
		closedDays.put(Days.FRIDAY, 0);
		closedDays.put(Days.FRIDAY, 6);
		closedDays.put(Days.SATURDAY, 0);
		closedDays.put(Days.SATURDAY, 6);
		closedDays.put(Days.SUNDAY, -1);
		Facility f = new Facility("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable(s,e,a,f,3);
		
		Timetable t2 = new Timetable(s,e,a,f,4);
		
		a.addReservation(t);

		assertFalse(a.removeReservation(t2));
		assertTrue(a.getReservations().size() == 1);
	}
	
	@Test
	void getReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		closedDays.put(Days.MONDAY, 0);
		closedDays.put(Days.MONDAY, 6);
		closedDays.put(Days.TUESDAY, 0);
		closedDays.put(Days.TUESDAY, 6);
		closedDays.put(Days.WEDNESDAY, 0);
		closedDays.put(Days.WEDNESDAY, 6);
		closedDays.put(Days.THURSDAY, 0);
		closedDays.put(Days.THURSDAY, 6);
		closedDays.put(Days.FRIDAY, 0);
		closedDays.put(Days.FRIDAY, 6);
		closedDays.put(Days.SATURDAY, 0);
		closedDays.put(Days.SATURDAY, 6);
		closedDays.put(Days.SUNDAY, -1);
		Facility f = new Facility("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable(s,e,a,f,3);
		
		List<Timetable> reservations = new ArrayList<>();
		reservations.add(t);
		
		a.addReservation(t);

		assertEquals(reservations, a.getReservations());
	}

}
