package sportfacility.web.controllers.requests.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.requests.customer.SubmitCustomerRequest;
import sportfacility.web.controllers.requests.timetable.SubmitTimetableRequest;

public class SubmitFacilityRequestTest {

	@Test
	void constructorTest() 
	{
		new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
	}
	
	@Test
	void SubmitFacilityRequestCodeLessLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void SubmitFacilityRequestCodeMoreLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB123", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void SubmitFacilityRequestCodeDigitInsteadOfCharTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("1B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void SubmitFacilityRequestCodeCharInsteadOfDigitTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("ABC2", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void maxCapacityNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", -1, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void maxCapacityZeroTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", 0, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void pricePerHourNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", 10, -1, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The price per hour can't be lower than 0"));
	}
	
	@Test
	void numberOfChangingRoomsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", 10, 50, -1, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of changing rooms can't be lower than 0"));
	}
	
	@Test
	void numberOfFloodLightsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", 10, 50, 3, -1, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of flood lights can't be lower than 0"));
	}
	
	@Test
	void extraPriceForLightUseNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("AB12", 10, 50, 3, 20, -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("The extra price for flood light use can't be lower than 0"));
	}
	
	@Test
	void nullSubmitFacilityRequestCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest(null, 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void blankSubmitFacilityRequestCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityRequest("   ", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void addReservationTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertEquals(t, f.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		        	   f.addReservation(null);
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
		        	   SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		        	   f.removeReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't remove a null reservation"));
	}
	
	@Test
	void removeReservationTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertTrue(f.removeReservation(t));
		assertTrue(f.getReservations().size() == 0);
	}
	
	@Test
	void removeReservationNotFoundTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		SubmitTimetableRequest t2 = new SubmitTimetableRequest("b",s,e,a,f,4);
		
		f.addReservation(t);

		assertFalse(f.removeReservation(t2));
		assertTrue(f.getReservations().size() == 1);
	}
	
	@Test
	void getReservationTest() 
	{
		SubmitCustomerRequest a = new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
		
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		SubmitTimetableRequest t = new SubmitTimetableRequest("a",s,e,a,f,3);
		
		List<SubmitTimetableRequest> reservations = new ArrayList<>();
		reservations.add(t);
		
		f.addReservation(t);

		assertEquals(reservations, f.getReservations());
	}
	
	@Test
	void getSubmitFacilityRequestCodeTest() 
	{
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals("AB12", f.getFacilityCode());
	}
	
	@Test
	void getMaxCapacityTest() 
	{
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(10, f.getMaxCapacity());
	}
	
	@Test
	void getPricePerHourTest() 
	{
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(50, f.getPricePerHour());
	}
	
	@Test
	void getNumberOfChangingRoomsTest() 
	{

		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(3, f.getNumberOfChangingRooms());
	}
	
	@Test
	void getNumberOfFloodLightsTest() 
	{
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(20, f.getNumberOfFloodLights());
	}
	
	@Test
	void getExtraPriceForLightUseTest() 
	{
		SubmitFacilityRequest f = new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(13, f.getExtraPriceForLightUse());
	}
}
