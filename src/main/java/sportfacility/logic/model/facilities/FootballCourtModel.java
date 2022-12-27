package sportfacility.logic.model.facilities;

import sportfacility.data.entities.Days;

import java.util.HashMap;

public class FootballCourtModel extends FacilityModel{
	
    private int nFootballsRented;
    public FootballCourtModel(String facilityCode, int maxCapacity, int pricePerHour, HashMap<Days, Integer> closedDays, int numberOfChangingRooms, int numberOfFloodLights,
                         int extraPriceForLightUse, int nFootballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, closedDays, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNFootballsRented(nFootballsRented);
    }

    public int getNFootballsRented() {
        return nFootballsRented;
    }

    public void setNFootballsRented(int nFootballsRented) {
        if(nFootballsRented != 1 && nFootballsRented != 0)
            throw new IllegalArgumentException("The number of rented footballs cannot be over 1 or under 0");
        this.nFootballsRented = nFootballsRented;
    }
}
