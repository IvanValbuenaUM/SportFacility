package sportfacility.logic.suscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TimetableObserver implements Observer {
	
	@Autowired
    private RestTemplate rest;

	@Override
	public Boolean informDelete(String id) {
		try {
			rest.put("http://SportFacilityApplication/null-timetableModel/?id=" + id, null);
        } catch (HttpClientErrorException exception) {
            return false;
        }
        return true;
	}
    
}
