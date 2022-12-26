package sportfacility.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sportfacility.data.entities.facilities.Facility;

public interface FacilityRepository extends JpaRepository<Facility, String> {

}
