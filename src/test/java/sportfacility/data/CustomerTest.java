package sportfacility.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void constructorTest() 
	{
		new Customer("Albert", "Omen", 20, "123456V", 1234);
	}
	
	@Test
	void zeroAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 0, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void negativeAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidAgeTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", -10, "123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer must have at least 18 years"));
	}
	
	@Test
	void invalidIdMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "1123456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}
	
	@Test
	void invalidIdLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}
	
	@Test
	void invalidIdNotNumberTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "a23456V", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at position 0 must be a digit)"));
	}
	
	@Test
	void invalidIdNotLetterTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "1234567", 1234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (character at last position must be a letter)"));
	}
	
	@Test
	void invalidMembershipNumberLessLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "123456V", 234)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	@Test
	void invalidMembershipNumberMoreLenghtTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the membership number (incorrect lenght)"));
	}
	
	@Test
	void getNameTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Albert", a.getName());
	}
	
	@Test
	void getSurnameTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("Omen", a.getSurname());
	}
	
	@Test
	void getAgeTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(20, a.getAge());
	}
	
	@Test
	void getIdTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals("123456V", a.getId());
	}
	
	@Test
	void getMembershipNumberTest() 
	{
		Customer a = new Customer("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(1234, a.getMembershipNumber());
	}
	
	@Test
	void nullNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer(null, "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer큦 name is incorrect"));
	}
	
	@Test
	void blankNameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("   ", "Omen", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer큦 name is incorrect"));
	}
	
	@Test
	void nullSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", null, 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer큦 surname is incorrect"));
	}
	
	@Test
	void blankSurnameTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "   ", 20, "123456V", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer큦 surname is incorrect"));
	}
	
	@Test
	void nullIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, null, 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("The Customer큦 id null"));
	}
	
	@Test
	void blankIdTest() 
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
		           () -> new Customer("Albert", "Omen", 20, "   ", 12345)
		    );

		assertTrue(thrown.getMessage().contentEquals("Incorrect format for the id (incorrect lenght)"));
	}

}
