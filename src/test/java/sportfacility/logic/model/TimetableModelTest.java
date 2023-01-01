package sportfacility.logic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import sportfacility.logic.model.facilities.FacilityModel;


public class TimetableModelTest {

	@Test
	void constructorTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		new TimetableModel(s,e,a,f,3);
	}
	
	@Test
	void getStartReservationTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(s, t.getStartReservation());
	}
	
	@Test
	void getEndReservationTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(e, t.getEndReservation());
	}
	
	@Test
	void getCustomerModelTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(a, t.getCustomer());
	}
	
	@Test
	void getFacilityModelTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(f, t.getFacility());
	}
	
	@Test
	void getNumberOfPeopleTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(3, t.getNumberOfPeople());
	}
	
	@Test
	void getTotalPriceTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
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
		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		TimetableModel t = new TimetableModel(s,e,a,f,3);
		
		assertEquals(50, t.getTotalPrice());
	}
	
	@Test
	void setStartReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		       		
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
			       		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
			       		
			       		Calendar s = null;
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new TimetableModel(s,e,a,f,3);
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
		        	   CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		       		
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
			       		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = null;
			       		
			       		new TimetableModel(s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null end reservation"));
	}
	
	@Test
	void setCustomerModelNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   CustomerModel a = null;
		       		
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
			       		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new TimetableModel(s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null customer"));
	}
	
	@Test
	void setFacilityModelNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		     
			       		FacilityModel f = null;
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new TimetableModel(s,e,a,f,3);
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
		        	   CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		       		
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
			       		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new TimetableModel(s,e,a,f,-1);
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
		        	   CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		       		
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
			       		FacilityModel f = new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new TimetableModel(s,e,a,f,0);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
}
