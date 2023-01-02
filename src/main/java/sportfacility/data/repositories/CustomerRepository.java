package sportfacility.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sportfacility.data.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
