package sportfacility.web.controllers.requests.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.requests.customer.SubmitCustomerRequest;
import sportfacility.web.controllers.requests.facility.SubmitFacilityRequest;

public class SubmitTimetableRequestTest {

	@Test
	void constructorTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		new SubmitTimetableRequest("a",s,e,a,f,3);
	}
	
	@Test
	void getStartReservationTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(s, t.getStartReservation());
	}
	
	@Test
	void getEndReservationTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(e, t.getEndReservation());
	}
	
	@Test
	void getSubmitCustomerRequestTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(a, t.getCustomer());
	}
	
	@Test
	void getSubmitFacilityRequestTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(f, t.getFacility());
	}
	
	@Test
	void getNumberOfPeopleTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(3, t.getNumberOfPeople());
	}
	
	@Test
	void getTotalPriceTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(50, t.getTotalPrice());
	}
	
	@Test
	void setStartReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = null;
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,3);
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
		        	   SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = null;
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null end reservation"));
	}
	
	@Test
	void setSubmitCustomerRequestNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   SubmitCustomerRequest a = null;
		       		
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null customer"));
	}
	
	@Test
	void setSubmitFacilityRequestNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		     
			       		SubmitFacilityRequest f = null;
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,3);
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
		        	   SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,-1);
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
		        	   SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new SubmitTimetableRequest("a",s,e,a,f,0);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
}
