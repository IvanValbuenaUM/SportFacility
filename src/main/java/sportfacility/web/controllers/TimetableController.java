package sportfacility.web.controllers;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import sportfacility.logic.TimetableLogic;
import sportfacility.logic.model.TimetableModel;
import sportfacility.web.controllers.requests.timetable.SubmitTimetableRequest;
import sportfacility.web.controllers.requests.timetable.UpdateTimetableRequest;
import sportfacility.web.controllers.responses.timetable.GetTimetableResponse;
import sportfacility.web.controllers.responses.timetable.SubmitTimetableResponse;

@Service
public class TimetableController {

	@Autowired
    TimetableLogic timetableLogic;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubmitTimetableResponse> submit(@RequestBody SubmitTimetableRequest request) 
    {
    	TimetableModel timetableSubmission = mapper.map(request, TimetableModel.class);
        
        String timetableId = timetableLogic.addTimetable(timetableSubmission);

        return ResponseEntity.ok(new SubmitTimetableResponse(timetableId));
    }
    
    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetTimetableResponse> get(@RequestParam String timetableId) 
    {
        TimetableModel timetableModel = timetableLogic.getTimetable(timetableId);

        if (timetableModel.equals(null)) {
            return ResponseEntity.notFound().build();
        }

        GetTimetableResponse getTimetableResponse = mapper.map(timetableModel, GetTimetableResponse.class);
        return ResponseEntity.ok(getTimetableResponse);
    }
    
    @GetMapping(value = "get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetTimetableResponse>> getAll(@RequestParam String parameterToSort) 
    {
    	List<TimetableModel> timetables = timetableLogic.getAllTimetables(parameterToSort);
    	List<GetTimetableResponse> timetablesResponse = new LinkedList<>();

        for (TimetableModel timetable : timetables) 
        	timetablesResponse.add(mapper.map(timetable, GetTimetableResponse.class));

        return ResponseEntity.ok(timetablesResponse);
    }
    
    @DeleteMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam String timetableId) 
    {
        if (!timetableLogic.deleteTimetable(timetableId))
        	return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UpdateTimetableRequest request) 
    {
        if (!timetableLogic.updateTimetable(mapper.map(request, TimetableModel.class))) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
