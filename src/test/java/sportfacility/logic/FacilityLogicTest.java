package sportfacility.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import sportfacility.data.repositories.FacilityRepository;
import sportfacility.logic.model.facilities.FacilityModel;

public class FacilityLogicTest extends LogicTest{

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private FacilityLogic logic;

    @Autowired
    private FacilityRepository repository;

    @MockBean
    private RestTemplate rest;

    public FacilityLogicTest(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }

    @Test
	public void addCustomerTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		
		assertEquals("AB12", logic.addFacility(f));
	}
    
    @Test
	public void addNullFacilityTest() 
	{
		boolean thrown = false;

		  try {
			  logic.addFacility(null);
		  } catch (IllegalArgumentException e) {
		    thrown = true;
		  }

		  assertTrue(thrown);
	}
    
    @Test
	public void getCustomerTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		logic.addFacility(f);
		
		assertEquals("AB12", logic.getFacility("AB12").getFacilityCode());
		assertEquals(10, logic.getFacility("AB12").getMaxCapacity());
		assertEquals(50, logic.getFacility("AB12").getPricePerHour());
		assertEquals(3, logic.getFacility("AB12").getNumberOfChangingRooms());
		assertEquals(20, logic.getFacility("AB12").getNumberOfFloodLights());
		assertEquals(13, logic.getFacility("AB12").getExtraPriceForLightUse());
	}
    
    @Test
	public void getNullFacilityTest() 
	{
		assertEquals(null, logic.getFacility("AB12"));
	}
    
    @Test
	public void getAllFacilitiesTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		logic.addFacility(f);
		
		FacilityModel f2 = new FacilityModel("AB13", 11, 51, 4, 21, 14);
		logic.addFacility(f2);
		
		List<FacilityModel> allFacilities = logic.getAllFacilities(null);
		
		assertEquals("AB12", allFacilities.get(0).getFacilityCode());
		assertEquals(10, allFacilities.get(0).getMaxCapacity());
		assertEquals(50, allFacilities.get(0).getPricePerHour());
		assertEquals(3, allFacilities.get(0).getNumberOfChangingRooms());
		assertEquals(20, allFacilities.get(0).getNumberOfFloodLights());
		assertEquals(13, allFacilities.get(0).getExtraPriceForLightUse());
		
		assertEquals("AB13", allFacilities.get(1).getFacilityCode());
		assertEquals(11, allFacilities.get(1).getMaxCapacity());
		assertEquals(51, allFacilities.get(1).getPricePerHour());
		assertEquals(4, allFacilities.get(1).getNumberOfChangingRooms());
		assertEquals(21, allFacilities.get(1).getNumberOfFloodLights());
		assertEquals(14, allFacilities.get(1).getExtraPriceForLightUse());
	}
	
	@Test
	public void getAllCustomersSortedByAgeTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		logic.addFacility(f);
		
		FacilityModel f2 = new FacilityModel("AB13", 11, 51, 4, 19, 14);
		logic.addFacility(f2);
		
		List<FacilityModel> allFacilities = logic.getAllFacilities("numberOfFloodLights");
		
		assertEquals("AB13", allFacilities.get(0).getFacilityCode());
		assertEquals(11, allFacilities.get(0).getMaxCapacity());
		assertEquals(51, allFacilities.get(0).getPricePerHour());
		assertEquals(4, allFacilities.get(0).getNumberOfChangingRooms());
		assertEquals(19, allFacilities.get(0).getNumberOfFloodLights());
		assertEquals(14, allFacilities.get(0).getExtraPriceForLightUse());
		
		assertEquals("AB12", allFacilities.get(1).getFacilityCode());
		assertEquals(10, allFacilities.get(1).getMaxCapacity());
		assertEquals(50, allFacilities.get(1).getPricePerHour());
		assertEquals(3, allFacilities.get(1).getNumberOfChangingRooms());
		assertEquals(20, allFacilities.get(1).getNumberOfFloodLights());
		assertEquals(13, allFacilities.get(1).getExtraPriceForLightUse());
	}
	
	@Test
	public void deleteFacilityTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		logic.addFacility(f);
		
		assertTrue(logic.deleteFacility("AB12"));
	}
	
//	@Test
//	public void deleteNullTest() 
//	{
//		assertFalse(logic.deleteFacility("AB12"));
//	}
	
	@Test
	public void updateFacilityTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		logic.addFacility(f);
		
		FacilityModel f2 = new FacilityModel("AB12", 11, 51, 4, 19, 14);
		logic.addFacility(f2);
		
		assertTrue(logic.updateFacility(f2));
		
		assertEquals("AB12", logic.getFacility("AB12").getFacilityCode());
		assertEquals(11, logic.getFacility("AB12").getMaxCapacity());
		assertEquals(51, logic.getFacility("AB12").getPricePerHour());
		assertEquals(4, logic.getFacility("AB12").getNumberOfChangingRooms());
		assertEquals(19, logic.getFacility("AB12").getNumberOfFloodLights());
		assertEquals(14, logic.getFacility("AB12").getExtraPriceForLightUse());
	}
	
	@Test
	public void updateNonExistingCustomersTest() 
	{
		FacilityModel f = new FacilityModel("AB12", 10, 50, 3, 20, 13);
		
		assertFalse(logic.updateFacility(f));
	}
}
