package sportfacility.data;

import javax.persistence.*;

import sportfacility.data.facilities.Facility;

public class Timetable {
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Facility facility;

}
