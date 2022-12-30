package sportfacility.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import sportfacility.data.entities.facilities.Facility;
import sportfacility.data.repositories.FacilityRepository;
import sportfacility.logic.model.facilities.FacilityModel;


public class FacilityLogic {
	
	@Autowired
	FacilityRepository repository;

    @Autowired
    ModelMapper mapper;
    
    public String addFacility(FacilityModel facility) 
    {
    	Facility facilityEntity = mapper.map(facility, Facility.class);
    	facilityEntity = repository.save(facilityEntity);
        return facilityEntity.getFacilityCode();
    }
    
    public Optional<FacilityModel> getFacility(String facilityCode) 
    {
        Optional<FacilityModel> facility = Optional.empty();

        facility = Optional.of(mapper.map(repository.findById(facilityCode), FacilityModel.class));

        return facility;
    }
    
    public List<FacilityModel> getAllFacilities(String parameterToSort) 
    {
    	List<FacilityModel> allFacilities = new LinkedList<>();
    	
    	if (parameterToSort == null)
    	{
    		for (Facility f : repository.findAll())
    		{
    			allFacilities.add(mapper.map(f, FacilityModel.class));
    		}
    		
    		return allFacilities;
    	}
    	for (Facility f : repository.findAll(Sort.by(Sort.Direction.ASC, parameterToSort)))
    	{
			allFacilities.add(mapper.map(f, FacilityModel.class));
		}
		
		return allFacilities;
    }
    
    public boolean deleteFacility(String facilityCode) 
    {

        repository.deleteById(facilityCode);
        return true;
    }
    
    public boolean updateFacility(FacilityModel facilityModel) 
    {

        if (repository.existsById(facilityModel.getFacilityCode()))
        {
        	repository.save(mapper.map(facilityModel, Facility.class));
        	return true;
        }
        return false;
    }
}
