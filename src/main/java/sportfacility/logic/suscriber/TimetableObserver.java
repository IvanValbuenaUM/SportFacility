package sportfacility.logic.suscriber;

import org.springframework.beans.factory.annotation.Autowired;

import sportfacility.data.repositories.TimetableRepository;

public class TimetableObserver implements Observer {
	
	@Autowired
	private TimetableRepository repository;
	
	private String timetableId;

	public TimetableObserver(String timetableId, TimetableRepository repository) {
		this.repository = repository;
		this.timetableId = timetableId;
	}

	@Override
	public Boolean update() {
		if(repository.existsById(timetableId))
			return true;
        return false;
	}
    
}
