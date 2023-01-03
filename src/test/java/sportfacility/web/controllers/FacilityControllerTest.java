package sportfacility.web.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import sportfacility.data.repositories.FacilityRepository;
import sportfacility.web.controllers.requests.facility.SubmitFacilityRequest;
import sportfacility.web.controllers.requests.facility.UpdateFacilityRequest;
import sportfacility.web.controllers.responses.facility.GetFacilityResponse;
import sportfacility.web.controllers.responses.facility.SubmitFacilityResponse;

public class FacilityControllerTest extends ControllerTest {

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private FacilityController controller;
    
    @Autowired
    private FacilityRepository repository;

    @MockBean
    private RestTemplate rest;

    public FacilityControllerTest(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
	}
    
    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }

    @Test
    public void submitTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	SubmitFacilityResponse res = controller.submit(req).getBody();
    	
    	assertEquals(req.getFacilityCode(), res.getFacilityCode());
    }
    
    @Test
    public void getTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	controller.submit(req);
    	
    	GetFacilityResponse res = controller.get("AB12").getBody();
    	
    	assertEquals(req.getFacilityCode(), res.getFacilityCode());
    	assertEquals(req.getExtraPriceForLightUse(), res.getExtraPriceForLightUse());
    	assertEquals(req.getMaxCapacity(), res.getMaxCapacity());
    	assertEquals(req.getNumberOfChangingRooms(), res.getNumberOfChangingRooms());
    	assertEquals(req.getNumberOfFloodLights(), res.getNumberOfFloodLights());
    	assertEquals(req.getPricePerHour(), res.getPricePerHour());
    	assertEquals(req.getReservations(), res.getReservations());
    }
    
    @Test
    public void getAllTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	controller.submit(req);
    	
    	SubmitFacilityRequest req2 =new SubmitFacilityRequest("AB13", 11, 51, 4, 21, 14);
    	controller.submit(req2);
    	
    	GetFacilityResponse res = controller.getAll(null).getBody().get(0);
    	GetFacilityResponse res2 = controller.getAll(null).getBody().get(1);
    	
    	assertEquals(req.getFacilityCode(), res.getFacilityCode());
    	assertEquals(req.getExtraPriceForLightUse(), res.getExtraPriceForLightUse());
    	assertEquals(req.getMaxCapacity(), res.getMaxCapacity());
    	assertEquals(req.getNumberOfChangingRooms(), res.getNumberOfChangingRooms());
    	assertEquals(req.getNumberOfFloodLights(), res.getNumberOfFloodLights());
    	assertEquals(req.getPricePerHour(), res.getPricePerHour());
    	assertEquals(req.getReservations(), res.getReservations());
    	
    	assertEquals(req2.getFacilityCode(), res2.getFacilityCode());
    	assertEquals(req2.getExtraPriceForLightUse(), res2.getExtraPriceForLightUse());
    	assertEquals(req2.getMaxCapacity(), res2.getMaxCapacity());
    	assertEquals(req2.getNumberOfChangingRooms(), res2.getNumberOfChangingRooms());
    	assertEquals(req2.getNumberOfFloodLights(), res2.getNumberOfFloodLights());
    	assertEquals(req2.getPricePerHour(), res2.getPricePerHour());
    	assertEquals(req2.getReservations(), res2.getReservations());
    }
    
    @Test
    public void getAllSortedByFacilityCodeTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB13", 11, 51, 4, 21, 14);
    	controller.submit(req);
    	
    	SubmitFacilityRequest req2 =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	controller.submit(req2);
    	
    	GetFacilityResponse res = controller.getAll(null).getBody().get(1);
    	GetFacilityResponse res2 = controller.getAll(null).getBody().get(0);
    	
    	assertEquals(req2.getFacilityCode(), res.getFacilityCode());
    	assertEquals(req2.getExtraPriceForLightUse(), res.getExtraPriceForLightUse());
    	assertEquals(req2.getMaxCapacity(), res.getMaxCapacity());
    	assertEquals(req2.getNumberOfChangingRooms(), res.getNumberOfChangingRooms());
    	assertEquals(req2.getNumberOfFloodLights(), res.getNumberOfFloodLights());
    	assertEquals(req2.getPricePerHour(), res.getPricePerHour());
    	assertEquals(req2.getReservations(), res.getReservations());
    	
    	assertEquals(req.getFacilityCode(), res2.getFacilityCode());
    	assertEquals(req.getExtraPriceForLightUse(), res2.getExtraPriceForLightUse());
    	assertEquals(req.getMaxCapacity(), res2.getMaxCapacity());
    	assertEquals(req.getNumberOfChangingRooms(), res2.getNumberOfChangingRooms());
    	assertEquals(req.getNumberOfFloodLights(), res2.getNumberOfFloodLights());
    	assertEquals(req.getPricePerHour(), res2.getPricePerHour());
    	assertEquals(req.getReservations(), res2.getReservations());
    }
    
    @Test
    public void deleteTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	controller.submit(req);
    	
    	
    	ResponseEntity<?> res = controller.delete("AB12");
    	
    	assertEquals(HttpStatus.OK, res.getStatusCode());
    }
    
//    @Test
//    public void deleteNonExistingTest()
//    {
//    	ResponseEntity<?> res = controller.delete(1234);
//    	
//    	assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
//    }
    
    @Test
    public void updateTest()
    {
    	SubmitFacilityRequest req =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	controller.submit(req);
    	
    	UpdateFacilityRequest req2 = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.OK, res.getStatusCode());
    }
    
    @Test
    public void updateNonExistingTest()
    {
    	UpdateFacilityRequest req2 = new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);

    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
    }

}
