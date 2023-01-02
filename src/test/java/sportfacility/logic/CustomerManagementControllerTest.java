package sportfacility.logic;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import sportfacility.data.repositories.CustomerRepository;
import sportfacility.logic.model.CustomerModel;

public class CustomerManagementControllerTest extends ControllerTest {

	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private CustomerLogic logic;

    @Autowired
    private CustomerRepository repository;

    @MockBean
    private RestTemplate rest;

    public CustomerManagementControllerTest(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @BeforeEach
    public void clearH2Db() {
        repository.deleteAll();
    }

    @Test
	public void addCustomerTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
		assertEquals(1234, logic.addCustomer(a));
	}
	
	@Test
	public void addNullCustomerTest() 
	{
		boolean thrown = false;

		  try {
			  logic.addCustomer(null);
		  } catch (IllegalArgumentException e) {
		    thrown = true;
		  }

		  assertTrue(thrown);
	}
	
	@Test
	public void getCustomerTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		logic.addCustomer(a);
		
		assertEquals("Albert", logic.getCustomer(1234).getName());
		assertEquals("Omen", logic.getCustomer(1234).getSurname());
		assertEquals(20, logic.getCustomer(1234).getAge());
		assertEquals("123456V", logic.getCustomer(1234).getId());
		assertEquals(1234, logic.getCustomer(1234).getMembershipNumber());
	}
	
	@Test
	public void getNullCustomerTest() 
	{
		assertEquals(null, logic.getCustomer(1234));
	}
	
	@Test
	public void getAllCustomersTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		CustomerModel b = new CustomerModel("Gulim", "Bulbs", 24, "654321A", 4321);
		logic.addCustomer(a);
		logic.addCustomer(b);
		
		List<CustomerModel> allCustomers = logic.getAllCustomers(null);
		
		assertEquals("Albert", allCustomers.get(0).getName());
		assertEquals("Omen", allCustomers.get(0).getSurname());
		assertEquals(20, allCustomers.get(0).getAge());
		assertEquals("123456V", allCustomers.get(0).getId());
		assertEquals(1234, allCustomers.get(0).getMembershipNumber());
		
		assertEquals("Gulim", allCustomers.get(1).getName());
		assertEquals("Bulbs", allCustomers.get(1).getSurname());
		assertEquals(24, allCustomers.get(1).getAge());
		assertEquals("654321A", allCustomers.get(1).getId());
		assertEquals(4321, allCustomers.get(1).getMembershipNumber());
	}
	
	@Test
	public void getAllCustomersSortedByAgeTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		CustomerModel b = new CustomerModel("Gulim", "Bulbs", 19, "654321A", 4321);
		logic.addCustomer(a);
		logic.addCustomer(b);
		
		List<CustomerModel> allCustomers = logic.getAllCustomers("age");
		
		assertEquals("Gulim", allCustomers.get(0).getName());
		assertEquals("Bulbs", allCustomers.get(0).getSurname());
		assertEquals(19, allCustomers.get(0).getAge());
		assertEquals("654321A", allCustomers.get(0).getId());
		assertEquals(4321, allCustomers.get(0).getMembershipNumber());
		
		
		assertEquals("Albert", allCustomers.get(1).getName());
		assertEquals("Omen", allCustomers.get(1).getSurname());
		assertEquals(20, allCustomers.get(1).getAge());
		assertEquals("123456V", allCustomers.get(1).getId());
		assertEquals(1234, allCustomers.get(1).getMembershipNumber());
	}
	
	@Test
	public void deleteCustomersTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		logic.addCustomer(a);
		
		assertTrue(logic.deleteCustomer(1234));
	}
	
//	CONFIGURE REST
//	@Test
//	public void deleteNullTest() 
//	{
//		assertFalse(logic.deleteCustomer(1234));
//	}
	
	@Test
	public void updateCustomersTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		logic.addCustomer(a);
		
		CustomerModel b = new CustomerModel("Gum", "Omen", 20, "123456V", 1234);
		
		assertTrue(logic.updateCustomer(b));
		
		assertEquals("Gum", logic.getCustomer(1234).getName());
		assertEquals("Omen", logic.getCustomer(1234).getSurname());
		assertEquals(20, logic.getCustomer(1234).getAge());
		assertEquals("123456V", logic.getCustomer(1234).getId());
		assertEquals(1234, logic.getCustomer(1234).getMembershipNumber());
	}
	
	@Test
	public void updateNonExistingCustomersTest() 
	{
		CustomerModel a = new CustomerModel("Albert", "Omen", 20, "123456V", 1234);
		
		assertFalse(logic.updateCustomer(a));
	}
}
