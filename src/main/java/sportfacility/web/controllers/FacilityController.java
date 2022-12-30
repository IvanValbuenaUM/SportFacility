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

import sportfacility.logic.FacilityLogic;
import sportfacility.logic.model.facilities.FacilityModel;
import sportfacility.web.controllers.requests.facility.SubmitFacilityRequest;
import sportfacility.web.controllers.requests.facility.UpdateFacilityRequest;
import sportfacility.web.controllers.responses.facility.DeleteFacilityResponse;
import sportfacility.web.controllers.responses.facility.GetFacilityResponse;
import sportfacility.web.controllers.responses.facility.SubmitFacilityResponse;
import sportfacility.web.controllers.responses.facility.UpdateFacilityResponse;

public class FacilityController {

	@Autowired
	FacilityLogic facilityLogic;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubmitFacilityResponse> submit(@RequestBody SubmitFacilityRequest request) 
    {
    	FacilityModel facilitySubmission = mapper.map(request, FacilityModel.class);
        
        String facilityId = facilityLogic.addFacility(facilitySubmission);

        return ResponseEntity.ok(new SubmitFacilityResponse(facilityId));
    }
    
    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetFacilityResponse> get(@RequestParam String facilityId) 
    {
        Optional<FacilityModel> facilityModel = facilityLogic.getFacility(facilityId);

        if (!facilityModel.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        GetFacilityResponse getFacilityResponse = mapper.map(facilityModel, GetFacilityResponse.class);
        return ResponseEntity.ok(getFacilityResponse);
    }
    
    @GetMapping(value = "get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetFacilityResponse>> getAll(@RequestParam String parameterToSort) 
    {
    	List<FacilityModel> facilities = facilityLogic.getAllFacilities(parameterToSort);
    	List<GetFacilityResponse> facilityResponse = new LinkedList<>();

        for (FacilityModel facility : facilities) 
        	facilityResponse.add(mapper.map(facility, GetFacilityResponse.class));

        return ResponseEntity.ok(facilityResponse);
    }
    
    @DeleteMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteFacilityResponse> delete(@RequestParam String facilityId) 
    {
        if (!facilityLogic.deleteFacility(facilityId))
        	return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateFacilityResponse> update(@RequestBody UpdateFacilityRequest request) 
    {
        if (!facilityLogic.updateFacility(mapper.map(request, FacilityModel.class))) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
