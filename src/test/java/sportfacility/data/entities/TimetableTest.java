package sportfacility.data.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import sportfacility.data.entities.facilities.Facility;

public class TimetableTest {

	@Test
	void constructorTest() 
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
		
		new Timetable("a",s,e,a,f,3);
	}
	
	@Test
	void getStartReservationTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(s, t.getStartReservation());
	}
	
	@Test
	void getEndReservationTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(e, t.getEndReservation());
	}
	
	@Test
	void getCustomerTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(a, t.getCustomer());
	}
	
	@Test
	void getFacilityTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(f, t.getFacility());
	}
	
	@Test
	void getNumberOfPeopleTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(3, t.getNumberOfPeople());
	}
	
	@Test
	void getTotalPriceTest() 
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
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		assertEquals(50, t.getTotalPrice());
	}
	
	@Test
	void setStartReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
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
			       		
			       		Calendar s = null;
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new Timetable("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null start reservation"));
	}
	
	@Test
	void setEndReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
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
			       		
			       		Calendar e = null;
			       		
			       		new Timetable("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null end reservation"));
	}
	
	@Test
	void setCustomerNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   Customer a = null;
		       		
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
			       		
			       		new Timetable("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null customer"));
	}
	
	@Test
	void setFacilityNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		     
			       		Facility f = null;
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new Timetable("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null facility"));
	}
	
	@Test
	void setNumberOfPeopleBelowZeroTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
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
			       		
			       		new Timetable("a",s,e,a,f,-1);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
	
	@Test
	void setNumberOfPeopleZeroTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
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
			       		
			       		new Timetable("a",s,e,a,f,0);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
}
