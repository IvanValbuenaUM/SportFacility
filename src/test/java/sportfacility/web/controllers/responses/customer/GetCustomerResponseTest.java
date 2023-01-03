package sportfacility.web.controllers.responses.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import sportfacility.web.controllers.responses.facility.GetFacilityResponse;
import sportfacility.web.controllers.responses.timetable.GetTimetableResponse;

public class GetCustomerResponseTest {

	@Test
	void constructorTest() 
	{
		new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
	}
	
	@Test
	void zeroAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 0, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void negativeAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidIdMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "1123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect length)"));
	}
	
	@Test
	void invalidIdLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect length)"));
	}
	
	@Test
	void invalidIdNotNumberTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "a23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at position 0 must be a digit)"));
	}
	
	@Test
	void invalidIdNotLetterTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "1234567", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at last position must be a letter)"));
	}
	
	@Test
	void invalidMembershipNumberLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "123456V", 234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	@Test
	void invalidMembershipNumberMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	@Test
	void getNameTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Albert", a.getName());
	}
	
	@Test
	void getSurnameTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Omen", a.getSurname());
	}
	
	@Test
	void getAgeTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(20, a.getAge());
	}
	
	@Test
	void getIdTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("123456V", a.getId());
	}
	
	@Test
	void getMembershipNumberTest() 
	{
		GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(1234, a.getMembershipNumber());
	}
	
	@Test
	void nullNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse(null, "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer name is incorrect"));
	}
	
	@Test
	void blankNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("   ", "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer name is incorrect"));
	}
	
	@Test
	void nullSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", null, 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer surname is incorrect"));
	}
	
	@Test
	void blankSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "   ", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer surname is incorrect"));
	}
	
	@Test
	void nullIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, null, 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer id is null"));
	}
	
	@Test
	void blankIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new GetCustomerResponse("Albert", "Omen", 20, "   ", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect length)"));
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
		
		a.addReservation(t);

		assertEquals(t, a.getReservations().get(0));
	}
	
	@Test
	void addReservationNullTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> {
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		        	   a.addReservation(null);
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
		        	   GetCustomerResponse a = new GetCustomerResponse("Albert", "Omen", 20, "123456V", 1234);
		        	   a.removeReservation(null);
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
		
		a.addReservation(t);

		assertTrue(a.removeReservation(t));
		assertTrue(a.getReservations().size() == 0);
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
		
		GetTimetableResponse t2 = new GetTimetableResponse("a",s,e,a,f,4);
		
		a.addReservation(t);

		assertFalse(a.removeReservation(t2));
		assertTrue(a.getReservations().size() == 1);
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
		
		a.addReservation(t);

		assertEquals(reservations, a.getReservations());
	}
}
