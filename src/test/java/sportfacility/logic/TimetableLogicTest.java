package sportfacility.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import sportfacility.data.repositories.TimetableRepository;
import sportfacility.logic.model.CustomerModel;
import sportfacility.logic.model.Days;
import sportfacility.logic.model.TimetableModel;
import sportfacility.logic.model.facilities.FacilityModel;

public class TimetableLogicTest extends ControllerTest {

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private TimetableLogic logic;

    @Autowired
    private TimetableRepository repository;

    @MockBean
    private RestTemplate rest;

    public TimetableLogicTest(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }
    
    @Test
	public void addTimetableTest() 
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
		
		TimetableModel t = new TimetableModel("a",s,e,a,f,3);
		
		assertEquals("a", logic.addTimetable(t));
	}
	
	@Test
	public void addNullTimetableTest() 
	{
		boolean thrown = false;

		  try {
			  logic.addTimetable(null);
		  } catch (IllegalArgumentException e) {
		    thrown = true;
		  }

		  assertTrue(thrown);
	}
	
	@Test
	public void getTimetableTest() 
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
		
		TimetableModel t = new TimetableModel("a",s,e,a,f,3);
		logic.addTimetable(t);
		
		assertEquals(t.getId(), logic.getTimetable(t.getId()).getId());
		assertEquals(s, logic.getTimetable(t.getId()).getStartReservation());
		assertEquals(e, logic.getTimetable(t.getId()).getEndReservation());
		assertEquals(a, logic.getTimetable(t.getId()).getCustomer());
		assertEquals(f, logic.getTimetable(t.getId()).getFacility());
		assertEquals(3, logic.getTimetable(t.getId()).getNumberOfPeople());
	}
	
	@Test
	public void getNullTimetableTest() 
	{
		assertEquals(null, logic.getTimetable("Ham"));
	}
	
	@Test
	public void getAllTimetablesTest() 
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
		
		Calendar s1 = Calendar.getInstance();
		s1.set(2022, 12, 20, 12, 0);
		
		Calendar e1 = Calendar.getInstance();
		e1.set(2022, 12, 20, 13, 0);
		
		TimetableModel t1 = new TimetableModel("a",s1,e1,a,f,3);
		logic.addTimetable(t1);
		
		Calendar s2 = Calendar.getInstance();
		s2.set(2022, 12, 24, 12, 0);
		
		Calendar e2 = Calendar.getInstance();
		e2.set(2022, 12, 24, 13, 0);

		TimetableModel t2 = new TimetableModel("b",s2,e2,a,f,5);
		
		logic.addTimetable(t2);
		
		List<TimetableModel> allTimetables = logic.getAllTimetables(null);
		
		assertEquals(t1.getId(), allTimetables.get(0).getId());
		assertEquals(s1, allTimetables.get(0).getStartReservation());
		assertEquals(e1, allTimetables.get(0).getEndReservation());
		assertEquals(a, allTimetables.get(0).getCustomer());
		assertEquals(f, allTimetables.get(0).getFacility());
		assertEquals(3, allTimetables.get(0).getNumberOfPeople());
		
		assertEquals(t2.getId(), allTimetables.get(1).getId());
		assertEquals(s2, allTimetables.get(1).getStartReservation());
		assertEquals(e2, allTimetables.get(1).getEndReservation());
		assertEquals(a, allTimetables.get(1).getCustomer());
		assertEquals(f, allTimetables.get(1).getFacility());
		assertEquals(5, allTimetables.get(1).getNumberOfPeople());
	}
	
	@Test
	public void getAllTimetablesSortedByAgeTest() 
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
		
		Calendar s1 = Calendar.getInstance();
		s1.set(2022, 12, 20, 12, 0);
		
		Calendar e1 = Calendar.getInstance();
		e1.set(2022, 12, 20, 13, 0);
		
		TimetableModel t1 = new TimetableModel("a",s1,e1,a,f,5);
		logic.addTimetable(t1);
		
		Calendar s2 = Calendar.getInstance();
		s2.set(2022, 12, 24, 12, 0);
		
		Calendar e2 = Calendar.getInstance();
		e2.set(2022, 12, 24, 13, 0);

		TimetableModel t2 = new TimetableModel("b",s2,e2,a,f,3);
		
		logic.addTimetable(t2);
		
		List<TimetableModel> allTimetables = logic.getAllTimetables("numberOfPeople");
		
		assertEquals(t2.getId(), allTimetables.get(0).getId());
		assertEquals(s2, allTimetables.get(0).getStartReservation());
		assertEquals(e2, allTimetables.get(0).getEndReservation());
		assertEquals(a, allTimetables.get(0).getCustomer());
		assertEquals(f, allTimetables.get(0).getFacility());
		assertEquals(3, allTimetables.get(0).getNumberOfPeople());
		
		assertEquals(t1.getId(), allTimetables.get(1).getId());
		assertEquals(s1, allTimetables.get(1).getStartReservation());
		assertEquals(e1, allTimetables.get(1).getEndReservation());
		assertEquals(a, allTimetables.get(1).getCustomer());
		assertEquals(f, allTimetables.get(1).getFacility());
		assertEquals(5, allTimetables.get(1).getNumberOfPeople());
	}
	
	@Test
	public void deleteTimetablesTest() 
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
		
		TimetableModel t = new TimetableModel("a",s,e,a,f,3);
		logic.addTimetable(t);
		
		assertTrue(logic.deleteTimetable(t.getId()));
	}
	
//	@Test
//	public void deleteNullTest() 
//	{
//		assertFalse(logic.deleteTimetable(1234));
//	}
	
	@Test
	public void updateTimetablesTest() 
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
		
		Calendar s1 = Calendar.getInstance();
		s1.set(2022, 12, 20, 12, 0);
		
		Calendar e1 = Calendar.getInstance();
		e1.set(2022, 12, 20, 13, 0);
		
		TimetableModel t1 = new TimetableModel("a",s1,e1,a,f,3);
		logic.addTimetable(t1);

		TimetableModel t2 = new TimetableModel("a",s1,e1,a,f,5);
		
		assertTrue(logic.updateTimetable(t2));
		
		assertEquals("a", logic.getTimetable(t2.getId()).getId());
		assertEquals(s1, logic.getTimetable(t2.getId()).getStartReservation());
		assertEquals(e1, logic.getTimetable(t2.getId()).getEndReservation());
		assertEquals(a, logic.getTimetable(t2.getId()).getCustomer());
		assertEquals(f, logic.getTimetable(t2.getId()).getFacility());
		assertEquals(3, logic.getTimetable(t2.getId()).getNumberOfPeople());
	}
	
	@Test
	public void updateNonExistingTimetablesTest() 
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
		
		TimetableModel t = new TimetableModel("a",s,e,a,f,3);
		
		assertFalse(logic.updateTimetable(t));
	}
}
