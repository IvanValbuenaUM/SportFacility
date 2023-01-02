package sportfacility.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sportfacility.data.entities.Customer;
import sportfacility.data.repositories.CustomerRepository;
import sportfacility.logic.model.CustomerModel;
import sportfacility.logic.suscriber.CustomerObserver;

@Service
public class CustomerLogic {
	
	@Autowired
	private CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private CustomerObserver observer;
    
    public int addCustomer(CustomerModel customer) 
    {
        Customer customerEntity = repository.save(mapper.map(customer, Customer.class));
        return customerEntity.getMembershipNumber();
    }
    
    public CustomerModel getCustomer(int customerMembershipNumber) 
    {

    	Optional<Customer> c = repository.findById(customerMembershipNumber);
    	
    	if(c.isEmpty())
    		return null;
    	
        CustomerModel customer = mapper.map(c.get(), CustomerModel.class);

        return customer;
    }
    
    public List<CustomerModel> getAllCustomers(String parameterToSort) 
    {
    	List<CustomerModel> allCustomers = new LinkedList<>();
    	
    	if (parameterToSort == null)
    	{
    		for (Customer c : repository.findAll())
    		{
    			allCustomers.add(mapper.map(c, CustomerModel.class));
    		}
    		
    		return allCustomers;
    	}
    	for (Customer c : repository.findAll(Sort.by(Sort.Direction.ASC, parameterToSort)))
    	{
			allCustomers.add(mapper.map(c, CustomerModel.class));
		}
		
		return allCustomers;
    }
    
    public boolean deleteCustomer(int customerMembershipNumber) 
    {
    	try {
    		repository.deleteById(customerMembershipNumber);
    	} catch (Exception e) {
    		
    	}
    	
    	if (!observer.informDelete(Integer.toString(customerMembershipNumber)))
    		return false;
        
        return true;
    }
    
    public boolean updateCustomer(CustomerModel customerModel) 
    {

        if (repository.existsById(customerModel.getMembershipNumber()))
        {
        	repository.save(mapper.map(customerModel, Customer.class));
        	return true;
        }
        return false;
    }
}
