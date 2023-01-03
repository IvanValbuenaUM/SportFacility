package sportfacility.web.controllers.requests.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.requests.customer.UpdateCustomerRequest;
import sportfacility.web.controllers.requests.facility.UpdateFacilityRequest;

public class UpdateTimetableRequestTest {

	@Test
	void constructorTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		new UpdateTimetableRequest("a",s,e,a,f,3);
	}
	
	@Test
	void getStartReservationTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(s, t.getStartReservation());
	}
	
	@Test
	void getEndReservationTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(e, t.getEndReservation());
	}
	
	@Test
	void getUpdateCustomerRequestTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(a, t.getCustomer());
	}
	
	@Test
	void getUpdateFacilityRequestTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(f, t.getFacility());
	}
	
	@Test
	void getNumberOfPeopleTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(3, t.getNumberOfPeople());
	}
	
	@Test
	void getTotalPriceTest() 
	{
		UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		UpdateTimetableRequest t = new UpdateTimetableRequest("a",s,e,a,f,3);
		
		assertEquals(50, t.getTotalPrice());
	}
	
	@Test
	void setStartReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = null;
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,3);
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
		        	   UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = null;
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null end reservation"));
	}
	
	@Test
	void setUpdateCustomerRequestNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   UpdateCustomerRequest a = null;
		       		
		        	   UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,3);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't set a null customer"));
	}
	
	@Test
	void setUpdateFacilityRequestNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		     
			       		UpdateFacilityRequest f = null;
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,3);
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
		        	   UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,-1);
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
		        	   UpdateCustomerRequest a = new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		       		
		        	   UpdateFacilityRequest f = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
			       		
			       		Calendar s = Calendar.getInstance();
			       		s.set(2022, 12, 20, 12, 0);
			       		
			       		Calendar e = Calendar.getInstance();
			       		e.set(2022, 12, 20, 13, 0);
			       		
			       		new UpdateTimetableRequest("a",s,e,a,f,0);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of people can't be lower or equal to 0"));
	}
}
