package sportfacility.data.entities;

import java.util.Calendar;

import javax.persistence.*;

import sportfacility.data.entities.facilities.Facility;

@Entity
public class Timetable {
	@Id
	@GeneratedValue
	private String id;
	
	private Calendar startReservation;
	
	private Calendar endReservation;
	
	private int numberOfPeople;
	
	private int totalPrice;
	
	
	@ManyToOne
	@JoinColumn(name="cust_membershipnumbe", nullable=false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="facility_code", nullable=false)
	private Facility facility;
	
	public Timetable(Calendar startReservation, Calendar endReservation, Customer customer, Facility facility, int numberOfPeople) {
		super();
		this.setStartReservation(startReservation);
		this.setEndReservation(endReservation);
		this.setCustomer(customer);
		this.setFacility(facility);
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

	public Customer getCustomer() 
	{
		return customer;
	}

	public Facility getFacility() 
	{
		return facility;
	}

	private void setStartReservation(Calendar startReservation) 
	{
		if (startReservation == null)
			throw new IllegalArgumentException("Can't set a null start reservation");
		
		this.startReservation = startReservation;
	}

	private void setEndReservation(Calendar endReservation) 
	{
		if (endReservation == null)
			throw new IllegalArgumentException("Can't set a null end reservation");
		
		this.endReservation = endReservation;
	}

	private void setCustomer(Customer customer) 
	{
		if (customer == null)
			throw new IllegalArgumentException("Can't set a null customer");
		
		this.customer = customer;
	}

	private void setFacility(Facility facility) 
	{
		if (facility == null)
			throw new IllegalArgumentException("Can't set a null facility");
		
		this.facility = facility;
	}

	public int getNumberOfPeople() 
	{
		return numberOfPeople;
	}

	private void setNumberOfPeople(int numberOfPeople) 
	{
		if (numberOfPeople <= 0)
			throw new IllegalArgumentException("The number of people can't be lower or equal to 0");
		
		this.numberOfPeople = numberOfPeople;
	}

	public String getId() {
		return id;
	}

	public int getTotalPrice() 
	{
		return totalPrice;
	}
	
}
