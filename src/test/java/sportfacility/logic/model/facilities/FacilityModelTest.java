package sportfacility.logic.model.facilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import sportfacility.logic.model.CustomerModel;
import sportfacility.logic.model.Days;
import sportfacility.logic.model.TimetableModel;

public class FacilityModelTest {

	@Test
	void constructorTest() 
	{
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
		
		new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13);
	}
	
	@Test
	void FacilityModelCodeLessLengthTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("B12", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void FacilityModelCodeMoreLengthTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB123", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void FacilityModelCodeDigitInsteadOfCharTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("1B12", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void FacilityModelCodeCharInsteadOfDigitTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("ABC2", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void maxCapacityNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", -1, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void maxCapacityZeroTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 0, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void pricePerHourNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 10, -1, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The price per hour can't be lower than 0"));
	}
	
	@Test
	void numberOfChangingRoomsNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 10, 50, closedDays, -1, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of changing rooms can't be lower than 0"));
	}
	
	@Test
	void numberOfFloodLightsNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 10, 50, closedDays, 3, -1, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of flood lights can't be lower than 0"));
	}
	
	@Test
	void extraPriceForLightUseNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 10, 50, closedDays, 3, 20, -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("The extra price for flood light use can't be lower than 0"));
	}
	
	@Test
	void nullFacilityModelCodeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel(null, 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void blankFacilityModelCodeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("   ", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void nullClosedDaysTest() 
	{
		HashMap<Days,Integer> closedDays = null;
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new FacilityModel("AB12", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The closed days hash map is null"));
	}
	
	@Test
	void addReservationTest() 
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
		
		f.addReservation(t);

		assertEquals(t, f.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
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
		        	   f.removeReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't remove a null reservation"));
	}
	
	@Test
	void removeReservationTest() 
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
		
		f.addReservation(t);

		assertTrue(f.removeReservation(t));
		assertTrue(f.getReservations().size() == 0);
	}
	
	@Test
	void removeReservationNotFoundTest() 
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
		
		TimetableModel t2 = new TimetableModel(s,e,a,f,4);
		
		f.addReservation(t);

		assertFalse(f.removeReservation(t2));
		assertTrue(f.getReservations().size() == 1);
	}
	
	@Test
	void getReservationTest() 
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
		
		List<TimetableModel> reservations = new ArrayList<>();
		reservations.add(t);
		
		f.addReservation(t);

		assertEquals(reservations, f.getReservations());
	}
	
	@Test
	void getFacilityModelCodeTest() 
	{
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
		
		assertEquals("AB12", f.getFacilityCode());
	}
	
	@Test
	void getMaxCapacityTest() 
	{
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
		
		assertEquals(10, f.getMaxCapacity());
	}
	
	@Test
	void getPricePerHourTest() 
	{
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
		
		assertEquals(50, f.getPricePerHour());
	}
	
	@Test
	void getClosedDaysTest() 
	{
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
		
		assertEquals(closedDays, f.getClosedDays());
	}
	
	@Test
	void getNumberOfChangingRoomsTest() 
	{
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
		
		assertEquals(3, f.getNumberOfChangingRooms());
	}
	
	@Test
	void getNumberOfFloodLightsTest() 
	{
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
		
		assertEquals(20, f.getNumberOfFloodLights());
	}
	
	@Test
	void getExtraPriceForLightUseTest() 
	{
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
		
		assertEquals(13, f.getExtraPriceForLightUse());
	}
}
