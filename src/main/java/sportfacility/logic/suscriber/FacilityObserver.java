package sportfacility.logic.suscriber;

import org.springframework.beans.factory.annotation.Autowired;

import sportfacility.data.repositories.FacilityRepository;

public class FacilityObserver implements Observer {
	
	@Autowired
	private FacilityRepository repository;
	
	private String facilityCode;

	public FacilityObserver(String facilityCode, FacilityRepository repository) {
		this.facilityCode = facilityCode;
		this.repository = repository;
	}

	@Override
	public Boolean update() {
		if(repository.existsById(facilityCode))
			return true;
        return false;
	}
}