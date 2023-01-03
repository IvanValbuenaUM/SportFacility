package sportfacility.web.controllers.responses.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SubmitFacilityResponseTest {

	@Test
	void constructorTest() 
	{
		new SubmitFacilityResponse("AB12");
	}
	
	@Test
	void SubmitFacilityResponseCodeLessLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityResponse("B12")
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void SubmitFacilityResponseCodeMoreLengthTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityResponse("AB123")
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (incorrect length)"));
	}
	
	@Test
	void SubmitFacilityResponseCodeDigitInsteadOfCharTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityResponse("1B12")
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 0 must be a letter)"));
	}
	
	@Test
	void SubmitFacilityResponseCodeCharInsteadOfDigitTest() 
	{
		
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitFacilityResponse("ABC2")
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the facilityCode (character at position 2 must be a digit)"));
	}
	
	@Test
	void getSubmitFacilityResponseCodeTest() 
	{
		SubmitFacilityResponse f = new SubmitFacilityResponse("AB12");
		
		assertEquals("AB12", f.getFacilityCode());
	}
}
