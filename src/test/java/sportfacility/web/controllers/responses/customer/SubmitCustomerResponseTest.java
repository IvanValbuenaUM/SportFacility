package sportfacility.web.controllers.responses.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SubmitCustomerResponseTest {

	@Test
	void constructorTest() 
	{
		new SubmitCustomerResponse(1234);
	}
	
	@Test
	void invalidMembershipNumberLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitCustomerResponse(234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	@Test
	void invalidMembershipNumberMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new SubmitCustomerResponse(12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	
	@Test
	void getMembershipNumberTest() 
	{
		SubmitCustomerResponse a = new SubmitCustomerResponse(1234);
		
		assertEquals(1234, a.getMembershipNumber());
	}
	
}
