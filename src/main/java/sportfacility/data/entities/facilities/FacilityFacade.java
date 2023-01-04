package sportfacility.data.entities.facilities;

import java.util.List;

import sportfacility.data.entities.Timetable;

public interface FacilityFacade {

	public String getFacilityCode();
	public void setFacilityCode(String facilityCode);
	
	public int getMaxCapacity();
	public void setMaxCapacity(int maxCapacity);
	
	public int getPricePerHour();
	public void setPricePerHour(int pricePerHour);
	
	public int getNumberOfChangingRooms();
	public void setNumberOfChangingRooms(int numberOfChangingRooms);
	
	public int getNumberOfFloodLights();
	public void setNumberOfFloodLights(int numberOfFloodLights);
	
	public int getExtraPriceForLightUse();
	public void setExtraPriceForLightUse(int extraPriceForLightUse);
	
	public List<Timetable> getReservations();
	public void addReservation(Timetable t);
}
