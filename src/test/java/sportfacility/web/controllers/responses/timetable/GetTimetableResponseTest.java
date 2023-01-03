package sportfacility.web.controllers.responses.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.responses.customer.GetCustomerResponse;
import sportfacility.web.controllers.responses.facility.GetFacilityResponse;


public class GetTimetableResponseTest {

	@Test
	void constructorTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		new GetTimetableResponse("a",s,e,a,f,3);
	}
	
	@Test
	void getStartReservationTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(s, t.getStartReservation());
	}
	
	@Test
	void getEndReservationTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(e, t.getEndReservation());
	}
	
	@Test
	void getGetCustomerResponseTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(a, t.getCustomer());
	}
	
	@Test
	void getGetFacilityResponseTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(f, t.getFacility());
	}
	
	@Test
	void getNumberOfPeopleTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(3, t.getNumberOfPeople());
	}
	
	@Test
	void getTotalPriceTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		assertEquals(50, t.getTotalPrice());
	}
	
	@Test
	void setStartReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = null;
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new GetTimetableResponse("a",s,e,a,f,3);
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
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = null;
			       		
			       		new GetTimetableResponse("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null end reservation"));
	}
	
	@Test
	void setGetCustomerResponseNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   GetCustomerResponse a = null;
		       		
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new GetTimetableResponse("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null customer"));
	}
	
	@Test
	void setGetFacilityResponseNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		     
			       		GetFacilityResponse f = null;
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new GetTimetableResponse("a",s,e,a,f,3);
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
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new GetTimetableResponse("a",s,e,a,f,-1);
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
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new GetTimetableResponse("a",s,e,a,f,0);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
}
