package sportfacility.data.entities.facilities;

import sportfacility.data.entities.Days;
import sportfacility.data.entities.Timetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Facility {

	@Id
	@Column(name="facility_code")
	private String facilityCode;
	
	@Column(name="facility_maxcapacity")
	private int maxCapacity;
	
	@Column(name="facility_priceperhour")
	private int pricePerHour;
	
	@Column(name="facility_closeddays")
	private HashMap<Days, Integer> closedDays;
	
	@Column(name="facility_nchangingrooms")
	private int numberOfChangingRooms;
	
	@Column(name="facility_nfloodlights")
	private int numberOfFloodLights;
	
	@Column(name="facility_lightprice")
	private int extraPriceForLightUse;
	
	@OneToMany(mappedBy = "facility")
	private List<Timetable> reservations = new ArrayList<>();
	
	public Facility(String facilityCode, int maxCapacity, int pricePerHour, HashMap<Days, Integer> closedDays,
			int numberOfChangingRooms, int numberOfFloodLights, int extraPriceForLightUse) 
	{
		this.setFacilityCode(facilityCode);
		this.setMaxCapacity(maxCapacity);
		this.setPricePerHour(pricePerHour);
		this.setClosedDays(closedDays);
		this.setNumberOfChangingRooms(numberOfChangingRooms);
		this.setNumberOfFloodLights(numberOfFloodLights);
		this.setExtraPriceForLightUse(extraPriceForLightUse);
	}
	
	public String getFacilityCode() 
	{
		return facilityCode;
	}
	
	public int getMaxCapacity() 
	{
		return maxCapacity;
	}
	
	public int getPricePerHour() 
	{
		return pricePerHour;
	}
	
	public HashMap<Days, Integer> getClosedDays() 
	{
		return closedDays;
	}
	
	public int getNumberOfChangingRooms() {
		
		return numberOfChangingRooms;
	}
	
	public int getNumberOfFloodLights() 
	{
		return numberOfFloodLights;
	}
	
	public int getExtraPriceForLightUse() 
	{
		return extraPriceForLightUse;
	}
	
	private void setFacilityCode(String facilityCode) 
	{
		if (facilityCode == null || facilityCode.trim().isEmpty())
			throw new IllegalArgumentException("The facility code is incorrect");
		
		if (facilityCode.length() != 4)
			throw new IllegalArgumentException("Incorrect format for the facilityCode (incorrect length)");
		
		for (int i = 0; i < facilityCode.length()/2; i++)
		{
			if (!Character.isLetter(facilityCode.charAt(i)))
				throw new IllegalArgumentException("Incorrect format for the facilityCode (character at position " + i + " must be a letter)");
			
			if (!Character.isDigit(facilityCode.charAt(i + 2)))
				throw new IllegalArgumentException("Incorrect format for the facilityCode (character at position " + (i + 2) + " must be a digit)");		
		}
		
		this.facilityCode = facilityCode;
	}

	private void setMaxCapacity(int maxCapacity) 
	{
		if (maxCapacity <= 0)
			throw new IllegalArgumentException("The capacity must be higher than 0");
		
		this.maxCapacity = maxCapacity;
	}

	private void setPricePerHour(int pricePerHour) 
	{
		if (pricePerHour < 0)
			throw new IllegalArgumentException("The price per hour can't be lower than 0");
		
		this.pricePerHour = pricePerHour;
	}

	private void setClosedDays(HashMap<Days, Integer> closedDays) 
	{
		if (closedDays == null)
			throw new IllegalArgumentException("The closed days hash map is null");
		
		this.closedDays = closedDays;
	}

	private void setNumberOfChangingRooms(int numberOfChangingRooms) 
	{
		if (numberOfChangingRooms < 0)
			throw new IllegalArgumentException("The number of changing rooms can't be lower than 0");
		
		this.numberOfChangingRooms = numberOfChangingRooms;
	}

	private void setNumberOfFloodLights(int numberOfFloodLights) 
	{
		
		if (numberOfFloodLights < 0)
			throw new IllegalArgumentException("The number of flood lights can't be lower than 0");
		
		this.numberOfFloodLights = numberOfFloodLights;
	}

	private void setExtraPriceForLightUse(int extraPriceForLightUse) 
	{
		if (extraPriceForLightUse < 0)
			throw new IllegalArgumentException("The extra price for flood light use can't be lower than 0");
		
		this.extraPriceForLightUse = extraPriceForLightUse;
	}
	
	public void addReservation(Timetable t)
	{
		if (t == null)
			throw new IllegalArgumentException("Can't add a null reservation");
		
		reservations.add(t);
	}
	
	public boolean removeReservation(Timetable t)
	{
		if (t == null)
			throw new IllegalArgumentException("Can't remove a null reservation");
		
		for(int i = 0; i < reservations.size(); i++)
		{
			if (t.equals(reservations.get(i)))
			{
				reservations.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Timetable> getReservations() {
		return reservations;
	}

}
