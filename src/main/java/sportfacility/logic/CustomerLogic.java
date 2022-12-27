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

@Service
public class CustomerLogic {
	@Autowired
    CustomerRepository repository;

    @Autowired
    ModelMapper mapper;
    
    public String addCustomer(CustomerModel customer) 
    {
        Customer customerEntity = mapper.map(customer, Customer.class);
        customerEntity = repository.save(customerEntity);
        return customerEntity.getId();
    }
    
    public CustomerModel getCustomer(String customerMembershipNumber) 
    {
        Optional<Customer> customer =
                repository.findById(customerMembershipNumber);

        if (customer.isEmpty()) 
        	return null;

        CustomerModel customerModel = mapper.map(customer.get(), CustomerModel.class);

        return customerModel;
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
    
    public boolean deleteCustomer(String customerMembershipNumber) 
    {

        repository.deleteById(customerMembershipNumber);
        return true;
    }
    
    public boolean updateCustomer(CustomerModel customerModel) 
    {

        if (repository.existsById(customerModel.getId()))
        {
        	repository.save(mapper.map(customerModel, Customer.class));
        	return true;
        }
        return false;
    }
}
