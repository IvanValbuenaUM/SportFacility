package sportfacility.web.controllers.responses.timetable;

import java.util.Calendar;

import sportfacility.web.controllers.responses.customer.GetCustomerResponse;
import sportfacility.web.controllers.responses.facility.GetFacilityResponse;

public class GetTimetableResponse {

	private String id;
	private Calendar startReservation;
	private Calendar endReservation;
	private int numberOfPeople;
	private int totalPrice;
	
	private GetCustomerResponse customer;

	private GetFacilityResponse facility;
	
	public GetTimetableResponse() 
	{
		super();
	}
	
	public GetTimetableResponse(String id, Calendar startReservation, Calendar endReservation, GetCustomerResponse a, GetFacilityResponse f, int numberOfPeople) {
		super();
		this.setId(id);
		this.setStartReservation(startReservation);
		this.setEndReservation(endReservation);
		this.setCustomer(a);
		this.setFacility(f);
		this.setNumberOfPeople(numberOfPeople);
		this.totalPrice = (this.getEndReservation().get(Calendar.HOUR_OF_DAY) - this.getStartReservation().get(Calendar.HOUR_OF_DAY)) * this.getFacility().getPricePerHour();
	}
	
	public Calendar getStartReservation() 
	{
		return startReservation;
	}

	public Calendar getEndReservation() 
	{
		return endReservation;
	}

	public GetCustomerResponse getCustomer() 
	{
		return customer;
	}

	public GetFacilityResponse getFacility() 
	{
		return facility;
	}

	public void setStartReservation(Calendar startReservation) 
	{
		if (startReservation == null)
			throw new IllegalArgumentException("Can't set a null start reservation");
		
		this.startReservation = startReservation;
	}

	public void setEndReservation(Calendar endReservation) 
	{
		if (endReservation == null)
			throw new IllegalArgumentException("Can't set a null end reservation");
		
		this.endReservation = endReservation;
	}

	public void setCustomer(GetCustomerResponse a) 
	{
		if (a == null)
			throw new IllegalArgumentException("Can't set a null customer");
		
		this.customer = a;
	}

	public void setFacility(GetFacilityResponse facility) 
	{
		if (facility == null)
			throw new IllegalArgumentException("Can't set a null facility");
		
		this.facility = facility;
	}

	public int getNumberOfPeople() 
	{
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) 
	{
		if (numberOfPeople <= 0)
			throw new IllegalArgumentException("The number of people can't be lower or equal to 0");
		
		this.numberOfPeople = numberOfPeople;
	}

	public int getTotalPrice() 
	{
		return totalPrice;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
