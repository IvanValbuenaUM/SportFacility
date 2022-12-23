package sportfacility.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import sportfacility.data.Facility.Days;

public class FacilityTest {
	
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
		
		new Facility("AB12", 10, 50, closedDays, 3, 20, 13);
	}
	
	@Test
	void facilityCodeLessLengthTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("B12", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect lenght)"));
	}
	
	@Test
	void facilityCodeMoreLengthTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB123", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect lenght)"));
	}
	
	@Test
	void facilityCodeDigitInsteadOfCharTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("1B12", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void facilityCodeCharInsteadOfDigitTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("ABC2", 10, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void maxCapacityNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", -1, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void maxCapacityZeroTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 0, 50, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The capacity must be higher than 0"));
	}
	
	@Test
	void pricePerHourNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, -1, closedDays, 3, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The price per hour can't be lower than 0"));
	}
	
	@Test
	void numberOfChangingRoomsNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, closedDays, -1, 20, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of changing rooms can't be lower than 0"));
	}
	
	@Test
	void numberOfFloodLightsNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, closedDays, 3, -1, 13)
		    );

		assertTrue(thrown.getMessage().contentEquals("The number of flood lights can't be lower than 0"));
	}
	
	@Test
	void extraPriceForLightUseNegativeTest() 
	{
		HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Facility("AB12", 10, 50, closedDays, 3, 20, -1)
		    );

		assertTrue(thrown.getMessage().contentEquals("The extra price for flood light use can't be lower than 0"));
	}
}
