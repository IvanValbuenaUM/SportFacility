package sportfacility.web.controllers.responses.timetable;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SubmitTimetableResponseTest {

	@Test
	void constructorTest() 
	{
		new SubmitTimetableResponse("a");
	}
	
	@Test
	void getIdTest() 
	{
		SubmitTimetableResponse t = new SubmitTimetableResponse("a");
		
		assertEquals("a", t.getId());
	}

}
