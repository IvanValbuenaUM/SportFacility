package sportfacility.web.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

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

import sportfacility.data.repositories.TimetableRepository;
import sportfacility.web.controllers.requests.customer.SubmitCustomerRequest;
import sportfacility.web.controllers.requests.customer.UpdateCustomerRequest;
import sportfacility.web.controllers.requests.facility.SubmitFacilityRequest;
import sportfacility.web.controllers.requests.facility.UpdateFacilityRequest;
import sportfacility.web.controllers.requests.timetable.SubmitTimetableRequest;
import sportfacility.web.controllers.requests.timetable.UpdateTimetableRequest;
import sportfacility.web.controllers.responses.timetable.GetTimetableResponse;
import sportfacility.web.controllers.responses.timetable.SubmitTimetableResponse;

public class TimetableControllerTest extends ControllerTest {

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private TimetableController controller;
    
    @Autowired
    private CustomerController controllerC;
    
    @Autowired
    private FacilityController controllerF;
    
    @Autowired
    private TimetableRepository repository;

    @MockBean
    private RestTemplate rest;

    public TimetableControllerTest(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
	}
    
    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }

    @Test
    public void submitTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("a",s,e,a,f,3);
    	
    	controllerC.submit(a);
    	controllerF.submit(f);
    	
    	SubmitTimetableResponse res = controller.submit(req).getBody();
    	
    	assertEquals(req.getId(), res.getId());
    }
    
    @Test
    public void getTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("a",s,e,a,f,3);
    	controller.submit(req);
    	
    	GetTimetableResponse res = controller.get("a").getBody();
    	
    	assertEquals(req.getCustomer().getMembershipNumber(), res.getCustomer().getMembershipNumber());
    	assertEquals(req.getEndReservation(), res.getEndReservation());
    	assertEquals(req.getFacility().getFacilityCode(), res.getFacility().getFacilityCode());
    	assertEquals(req.getId(), res.getId());
    	assertEquals(req.getNumberOfPeople(), res.getNumberOfPeople());
    	assertEquals(req.getStartReservation(), res.getStartReservation());
    }
    
    @Test
    public void getAllTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("a",s,e,a,f,3);
    	controller.submit(req);
    	
    	SubmitTimetableRequest req2 =new SubmitTimetableRequest("b",s,e,a,f,4);
    	controller.submit(req2);
    	
    	GetTimetableResponse res = controller.getAll(null).getBody().get(0);
    	GetTimetableResponse res2 = controller.getAll(null).getBody().get(1);
    	
    	assertEquals(req.getCustomer().getMembershipNumber(), res.getCustomer().getMembershipNumber());
    	assertEquals(req.getEndReservation(), res.getEndReservation());
    	assertEquals(req.getFacility().getFacilityCode(), res.getFacility().getFacilityCode());
    	assertEquals(req.getId(), res.getId());
    	assertEquals(req.getNumberOfPeople(), res.getNumberOfPeople());
    	assertEquals(req.getStartReservation(), res.getStartReservation());
    	
    	assertEquals(req2.getCustomer().getMembershipNumber(), res2.getCustomer().getMembershipNumber());
    	assertEquals(req2.getEndReservation(), res2.getEndReservation());
    	assertEquals(req2.getFacility().getFacilityCode(), res2.getFacility().getFacilityCode());
    	assertEquals(req2.getId(), res2.getId());
    	assertEquals(req2.getNumberOfPeople(), res2.getNumberOfPeople());
    	assertEquals(req2.getStartReservation(), res2.getStartReservation());
    }
    
    @Test
    public void getAllSortedByIdTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("b",s,e,a,f,3);
    	controller.submit(req);
    	
    	SubmitTimetableRequest req2 =new SubmitTimetableRequest("a",s,e,a,f,4);
    	controller.submit(req2);
    	
    	GetTimetableResponse res = controller.getAll(null).getBody().get(1);
    	GetTimetableResponse res2 = controller.getAll(null).getBody().get(0);
    	
    	assertEquals(req2.getCustomer().getMembershipNumber(), res.getCustomer().getMembershipNumber());
    	assertEquals(req2.getEndReservation(), res.getEndReservation());
    	assertEquals(req2.getFacility().getFacilityCode(), res.getFacility().getFacilityCode());
    	assertEquals(req2.getId(), res.getId());
    	assertEquals(req2.getNumberOfPeople(), res.getNumberOfPeople());
    	assertEquals(req2.getStartReservation(), res.getStartReservation());
    	
    	assertEquals(req.getCustomer().getMembershipNumber(), res2.getCustomer().getMembershipNumber());
    	assertEquals(req.getEndReservation(), res2.getEndReservation());
    	assertEquals(req.getFacility().getFacilityCode(), res2.getFacility().getFacilityCode());
    	assertEquals(req.getId(), res2.getId());
    	assertEquals(req.getNumberOfPeople(), res2.getNumberOfPeople());
    	assertEquals(req.getStartReservation(), res2.getStartReservation());
    }
    
    @Test
    public void deleteTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("a",s,e,a,f,3);
    	controller.submit(req);
    	
    	
    	ResponseEntity<?> res = controller.delete("a");
    	
    	assertEquals(HttpStatus.OK, res.getStatusCode());
    }
    
//    @Test
//    public void deleteNonExistingTest()
//    {
//    	ResponseEntity<?> res = controller.delete("a");
//    	
//    	assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
//    }
    
    @Test
    public void updateTest()
    {
    	SubmitCustomerRequest a =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitFacilityRequest f =new SubmitFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
    	
    	SubmitTimetableRequest req =new SubmitTimetableRequest("a",s,e,a,f,3);
    	controller.submit(req);
    	
    	UpdateCustomerRequest a2 =new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	UpdateFacilityRequest f2 =new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	UpdateTimetableRequest req2 = new UpdateTimetableRequest("a",s,e,a2,f2,4);
    	
    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.OK, res.getStatusCode());
    }
    
    @Test
    public void updateNonExistingTest()
    {
    	UpdateCustomerRequest a =new UpdateCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	UpdateFacilityRequest f =new UpdateFacilityRequest("AB12", 10, 50, 3, 20, 13);
    	
    	Calendar s = Calendar.getInstance();
		s.set(2022, 12, 20, 12, 0);
		
		Calendar e = Calendar.getInstance();
		e.set(2022, 12, 20, 13, 0);
		
    	UpdateTimetableRequest req2 = new UpdateTimetableRequest("a",s,e,a,f,3);

    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
    }

}

