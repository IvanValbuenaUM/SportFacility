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

import sportfacility.data.repositories.CustomerRepository;
import sportfacility.logic.CustomerLogic;
import sportfacility.web.controllers.requests.customer.SubmitCustomerRequest;
import sportfacility.web.controllers.requests.customer.UpdateCustomerRequest;
import sportfacility.web.controllers.responses.customer.GetCustomerResponse;
import sportfacility.web.controllers.responses.customer.SubmitCustomerResponse;

public class CustomerControllerTest extends ControllerTest {

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private CustomerController controller;

    @Autowired
    CustomerLogic customerLogic;
    
    @Autowired
    private CustomerRepository repository;

    @MockBean
    private RestTemplate rest;

    public CustomerControllerTest(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }
    
    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }

    @Test
    public void submitTest()
    {
    	SubmitCustomerRequest req =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	
    	SubmitCustomerResponse res = controller.submit(req).getBody();
    	
    	assertEquals(req.getMembershipNumber(), res.getMembershipNumber());
    }
    
    @Test
    public void getTest()
    {
    	SubmitCustomerRequest req =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	controller.submit(req);
    	
    	GetCustomerResponse res = controller.get(1234).getBody();
    	
    	assertEquals(req.getMembershipNumber(), res.getMembershipNumber());
    	assertEquals(req.getAge(), res.getAge());
    	assertEquals(req.getId(), res.getId());
    	assertEquals(req.getName(), res.getName());
    	assertEquals(req.getReservations(), res.getReservations());
    	assertEquals(req.getSurname(), res.getSurname());
    }
    
    @Test
    public void getAllTest()
    {
    	SubmitCustomerRequest req =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	controller.submit(req);
    	
    	SubmitCustomerRequest req2 =new SubmitCustomerRequest("G", "A", 24, "654321V", 4321);
    	controller.submit(req2);
    	
    	GetCustomerResponse res = controller.getAll(null).getBody().get(0);
    	GetCustomerResponse res2 = controller.getAll(null).getBody().get(1);
    	
    	assertEquals(req.getMembershipNumber(), res.getMembershipNumber());
    	assertEquals(req.getAge(), res.getAge());
    	assertEquals(req.getId(), res.getId());
    	assertEquals(req.getName(), res.getName());
    	assertEquals(req.getReservations(), res.getReservations());
    	assertEquals(req.getSurname(), res.getSurname());
    	
    	assertEquals(req2.getMembershipNumber(), res2.getMembershipNumber());
    	assertEquals(req2.getAge(), res2.getAge());
    	assertEquals(req2.getId(), res2.getId());
    	assertEquals(req2.getName(), res2.getName());
    	assertEquals(req2.getReservations(), res2.getReservations());
    	assertEquals(req2.getSurname(), res2.getSurname());
    }
    
    @Test
    public void getAllSortedByAgeTest()
    {
    	SubmitCustomerRequest req =new SubmitCustomerRequest("G", "A", 24, "654321V", 4321);
    	controller.submit(req);
    	
    	SubmitCustomerRequest req2 =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	controller.submit(req2);
    	
    	GetCustomerResponse res = controller.getAll(null).getBody().get(1);
    	GetCustomerResponse res2 = controller.getAll(null).getBody().get(0);
    	
    	assertEquals(req.getMembershipNumber(), res.getMembershipNumber());
    	assertEquals(req.getAge(), res.getAge());
    	assertEquals(req.getId(), res.getId());
    	assertEquals(req.getName(), res.getName());
    	assertEquals(req.getReservations(), res.getReservations());
    	assertEquals(req.getSurname(), res.getSurname());
    	
    	assertEquals(req2.getMembershipNumber(), res2.getMembershipNumber());
    	assertEquals(req2.getAge(), res2.getAge());
    	assertEquals(req2.getId(), res2.getId());
    	assertEquals(req2.getName(), res2.getName());
    	assertEquals(req2.getReservations(), res2.getReservations());
    	assertEquals(req2.getSurname(), res2.getSurname());
    }
    
    @Test
    public void deleteTest()
    {
    	SubmitCustomerRequest req =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	controller.submit(req);
    	
    	
    	ResponseEntity<?> res = controller.delete(1234);
    	
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
    	SubmitCustomerRequest req =new SubmitCustomerRequest("Albert", "Omen", 20, "123456V", 1234);
    	controller.submit(req);
    	
    	UpdateCustomerRequest req2 = new UpdateCustomerRequest("G", "O", 24, "654321V", 1234);
    	
    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.OK, res.getStatusCode());
    }
    
    @Test
    public void updateNonExistingTest()
    {
    	UpdateCustomerRequest req2 = new UpdateCustomerRequest("G", "O", 24, "654321V", 1234);

    	ResponseEntity<?> res = controller.update(req2);
    	
    	assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
    }
}
