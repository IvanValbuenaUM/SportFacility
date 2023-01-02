package sportfacility.data.entities.facilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import sportfacility.data.entities.Customer;
import sportfacility.data.entities.Timetable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FacilityTest {
	
	@Test
	void constructorTest() 
	{
		new Facility("AB12", 10, 50, 3, 20, 13);
	}
	
	@Test
	void facilityCodeLessLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void facilityCodeMoreLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB123", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void facilityCodeDigitInsteadOfCharTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("1B12", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void facilityCodeCharInsteadOfDigitTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("ABC2", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void maxCapacityNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", -1, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void maxCapacityZeroTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 0, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void pricePerHourNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, -1, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The price per hour can't be lower than 0"));
	}
	
	@Test
	void numberOfChangingRoomsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, -1, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of changing rooms can't be lower than 0"));
	}
	
	@Test
	void numberOfFloodLightsNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, 3, -1, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of flood lights can't be lower than 0"));
	}
	
	@Test
	void extraPriceForLightUseNegativeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, 3, 20, -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("The extra price for flood light use can't be lower than 0"));
	}
	
	@Test
	void nullFacilityCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility(null, 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void blankFacilityCodeTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("   ", 10, 50, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The facility code is incorrect"));
	}
	
	@Test
	void addReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertEquals(t, f.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
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
		        	   Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		        	   f.removeReservation(null);
		           		 }
		    );

		assertTrue(thrown.getMessage().contentEquals("Can't remove a null reservation"));
	}
	
	@Test
	void removeReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		f.addReservation(t);

		assertTrue(f.removeReservation(t));
		assertTrue(f.getReservations().size() == 0);
	}
	
	@Test
	void removeReservationNotFoundTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		Timetable t2 = new Timetable("a",s,e,a,f,4);
		
		f.addReservation(t);

		assertFalse(f.removeReservation(t2));
		assertTrue(f.getReservations().size() == 1);
	}
	
	@Test
	void getReservationTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
		Timetable t = new Timetable("a",s,e,a,f,3);
		
		List<Timetable> reservations = new ArrayList<>();
		reservations.add(t);
		
		f.addReservation(t);

		assertEquals(reservations, f.getReservations());
	}
	
	@Test
	void getFacilityCodeTest() 
	{
		Facility f = new Facility("AB12", 10, 50,  3, 20, 13);
		
		assertEquals("AB12", f.getFacilityCode());
	}
	
	@Test
	void getMaxCapacityTest() 
	{
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(10, f.getMaxCapacity());
	}
	
	@Test
	void getPricePerHourTest() 
	{
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(50, f.getPricePerHour());
	}
	
	@Test
	void getNumberOfChangingRoomsTest() 
	{
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(3, f.getNumberOfChangingRooms());
	}
	
	@Test
	void getNumberOfFloodLightsTest() 
	{
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(20, f.getNumberOfFloodLights());
	}
	
	@Test
	void getExtraPriceForLightUseTest() 
	{
		Facility f = new Facility("AB12", 10, 50, 3, 20, 13);
		
		assertEquals(13, f.getExtraPriceForLightUse());
	}
}
