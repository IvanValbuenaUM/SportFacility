package sportfacility.web.controllers.responses.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.responses.customer.GetCustomerResponse;
import sportfacility.web.controllers.responses.timetable.GetTimetableResponse;

public class GetFacilityResponseTest {

	@Test
	void constructorTest() 
	{
		new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
	}
	
	@Test
	void GetFacilityResponseCodeLessLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void GetFacilityResponseCodeMoreLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB123", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void GetFacilityResponseCodeDigitInsteadOfCharTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("1B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void GetFacilityResponseCodeCharInsteadOfDigitTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("ABC2", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void maxCapacityNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", -1, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void maxCapacityZeroTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", 0, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void pricePerHourNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", 10, -1, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The price per hour can't be lower than 0"));
	}
	
	@Test
	void numberOfChangingRoomsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", 10, 50, -1, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of changing rooms can't be lower than 0"));
	}
	
	@Test
	void numberOfFloodLightsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", 10, 50, 3, -1, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of flood lights can't be lower than 0"));
	}
	
	@Test
	void extraPriceForLightUseNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("AB12", 10, 50, 3, 20, -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("The extra price for flood light use can't be lower than 0"));
	}
	
	@Test
	void nullGetFacilityResponseCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse(null, 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void blankGetFacilityResponseCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetFacilityResponse("   ", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void addReservationTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertEquals(t, f.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
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
		        	   GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		        	   f.removeReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't remove a null reservation"));
	}
	
	@Test
	void removeReservationTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertTrue(f.removeReservation(t));
		assertTrue(f.getReservations().size() == 0);
	}
	
	@Test
	void removeReservationNotFoundTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		GetTimetableResponse t2 = new GetTimetableResponse("b",s,e,a,f,4);
		
		f.addReservation(t);

		assertFalse(f.removeReservation(t2));
		assertTrue(f.getReservations().size() == 1);
	}
	
	@Test
	void getReservationTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		GetTimetableResponse t = new GetTimetableResponse("a",s,e,a,f,3);
		
		List<GetTimetableResponse> reservations = new ArrayList<>();
		reservations.add(t);
		
		f.addReservation(t);

		assertEquals(reservations, f.getReservations());
	}
	
	@Test
	void getGetFacilityResponseCodeTest() 
	{
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals("AB12", f.getFacilityCode());
	}
	
	@Test
	void getMaxCapacityTest() 
	{
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(10, f.getMaxCapacity());
	}
	
	@Test
	void getPricePerHourTest() 
	{
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(50, f.getPricePerHour());
	}
	
	@Test
	void getNumberOfChangingRoomsTest() 
	{

		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(3, f.getNumberOfChangingRooms());
	}
	
	@Test
	void getNumberOfFloodLightsTest() 
	{
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(20, f.getNumberOfFloodLights());
	}
	
	@Test
	void getExtraPriceForLightUseTest() 
	{
		GetFacilityResponse f = new GetFacilityResponse("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(13, f.getExtraPriceForLightUse());
	}
}
