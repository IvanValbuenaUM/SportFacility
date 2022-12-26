package sportfacility.data.entities.facilities;

import sportfacility.data.entities.Days;

import java.util.HashMap;

import javax.persistence.Entity;

@Entity
public class TennisCourt extends Facility{
    private int nTennisRacquetsRented;
    private int nTennisBallsRented;

    public TennisCourt(String facilityCode, int maxCapacity, int pricePerHour, HashMap<Days, Integer> closedDays, int numberOfChangingRooms, int numberOfFloodLights,
                       int extraPriceForLightUse, int nRacquetsRented, int nTennisBallsRented) {
        super(facilityCode, maxCapacity, pricePerHour, closedDays, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNTennisRacquetsRented(nRacquetsRented);
        setNTennisBallsRented(nTennisBallsRented);
    }

    public int getNTennisRacquetsRented() {
        return nTennisRacquetsRented;
    }

    public void setNTennisRacquetsRented(int nRacquetsRented) {
        if(nRacquetsRented < 0 || nRacquetsRented > 4)
            throw new IllegalArgumentException("The number of rented racquets cannot be over 4 or under 0");
        this.nTennisRacquetsRented = nRacquetsRented;
    }

    public int getNTennisBallsRented() {
        return nTennisBallsRented;
    }

    public void setNTennisBallsRented(int nTennisBallsRented) {
        if(nTennisBallsRented < 0 || nTennisBallsRented > 10)
            throw new IllegalArgumentException("The number of rented tennis balls cannot be over 10 or under 0");
        this.nTennisBallsRented = nTennisBallsRented;
    }
}
