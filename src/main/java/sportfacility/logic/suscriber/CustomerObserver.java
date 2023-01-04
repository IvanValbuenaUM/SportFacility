package sportfacility.logic.suscriber;

import org.springframework.beans.factory.annotation.Autowired;

import sportfacility.data.repositories.CustomerRepository;

public class CustomerObserver implements Observer {
	
	@Autowired
	private CustomerRepository repository;
	
	private int membershipNumber;
	
	public CustomerObserver(int membershipNumber, CustomerRepository repository) 
	{
		this.membershipNumber = membershipNumber;
		this.repository = repository;
	}
	
	@Override
	public Boolean update() {
		if(repository.existsById(membershipNumber))
			return true;
        return false;
	}
    
}
