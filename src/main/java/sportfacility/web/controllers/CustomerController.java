package sportfacility.web.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sportfacility.logic.CustomerLogic;
import sportfacility.logic.model.CustomerModel;
import sportfacility.web.controllers.requests.customer.SubmitCustomerRequest;
import sportfacility.web.controllers.requests.customer.UpdateCustomerRequest;
import sportfacility.web.controllers.responses.customer.DeleteCustomerResponse;
import sportfacility.web.controllers.responses.customer.GetCustomerResponse;
import sportfacility.web.controllers.responses.customer.SubmitCustomerResponse;
import sportfacility.web.controllers.responses.customer.UpdateCustomerResponse;

@RestController
public class CustomerController {
	
	@Autowired
    CustomerLogic customerLogic;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubmitCustomerResponse> submit(@RequestBody SubmitCustomerRequest request) 
    {
        CustomerModel customerSubmission = mapper.map(request, CustomerModel.class);
        
        String customerId = customerLogic.addCustomer(customerSubmission);

        return ResponseEntity.ok(new SubmitCustomerResponse(customerId));
    }
    
    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCustomerResponse> get(@RequestParam String customerMembershipNumber) 
    {
        Optional<CustomerModel> customerModel = customerLogic.getCustomer(customerMembershipNumber);

        if (!customerModel.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        GetCustomerResponse getCustomerResponse = mapper.map(customerModel, GetCustomerResponse.class);
        return ResponseEntity.ok(getCustomerResponse);
    }
    
    @GetMapping(value = "get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetCustomerResponse>> getAll(@RequestParam String parameterToSort) 
    {
    	List<CustomerModel> customers = customerLogic.getAllCustomers(parameterToSort);
    	List<GetCustomerResponse> customersResponse = new LinkedList<>();

        for (CustomerModel customer : customers) 
            customersResponse.add(mapper.map(customer, GetCustomerResponse.class));

        return ResponseEntity.ok(customersResponse);
    }
    
    @DeleteMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteCustomerResponse> delete(@RequestParam String customerMembershipNumber) 
    {
        if (!customerLogic.deleteCustomer(customerMembershipNumber))
        	return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateCustomerResponse> update(@RequestBody UpdateCustomerRequest request) 
    {
        if (!customerLogic.updateCustomer(mapper.map(request, CustomerModel.class))) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
