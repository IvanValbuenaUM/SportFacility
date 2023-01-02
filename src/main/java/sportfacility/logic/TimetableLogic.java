package sportfacility.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import sportfacility.data.entities.Timetable;
import sportfacility.data.repositories.TimetableRepository;
import sportfacility.logic.model.TimetableModel;
import sportfacility.logic.suscriber.TimetableObserver;

public class TimetableLogic {
	
	@Autowired
    private TimetableRepository repository; 

    @Autowired
    private ModelMapper mapper = new ModelMapper();
    
    @Autowired
    private TimetableObserver observer;
    
    public String addTimetable(TimetableModel timetable) 
    {
        Timetable timetableEntity = mapper.map(timetable, Timetable.class);
        timetableEntity = repository.save(timetableEntity);
        return timetableEntity.getId();
    }
    
    public Optional<TimetableModel> getTimetable(String timetableId) 
    {
        Optional<TimetableModel> timetable = Optional.empty();

        timetable = Optional.of(mapper.map(repository.findById(timetableId), TimetableModel.class));

        return timetable;
    }
    
    public List<TimetableModel> getAllTimetables(String parameterToSort) 
    {
    	List<TimetableModel> allTimetables = new LinkedList<>();
    	
    	if (parameterToSort == null)
    	{
    		for (Timetable t : repository.findAll())
    		{
    			allTimetables.add(mapper.map(t, TimetableModel.class));
    		}
    		
    		return allTimetables;
    	}
    	for (Timetable t : repository.findAll(Sort.by(Sort.Direction.ASC, parameterToSort)))
    	{
    		allTimetables.add(mapper.map(t, TimetableModel.class));
		}
		
		return allTimetables;
    }
    
    public boolean deleteTimetable(String timetableId) 
    {

        repository.deleteById(timetableId);
        
        if(!observer.informDelete(timetableId))
        	return false;
        
        return true;
    }
    
    public boolean updateTimetable(TimetableModel timetableModel) 
    {

        if (repository.existsById(timetableModel.getId()))
        {
        	repository.save(mapper.map(timetableModel, Timetable.class));
        	return true;
        }
        return false;
    }
}
