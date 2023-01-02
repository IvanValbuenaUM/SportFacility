package sportfacility.logic.suscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class FacilityObserver implements Observer {

	@Autowired
    private RestTemplate rest;

	@Override
	public Boolean informDelete(String id) {
		try {
			rest.put("http://SportFacilityApplication/null-facilityModel/?facility_code=" + id, null);
        } catch (HttpClientErrorException exception) {
            return false;
        }
        return true;
	}
}