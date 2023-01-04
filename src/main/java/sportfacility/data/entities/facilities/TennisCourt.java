package sportfacility.data.entities.facilities;


import javax.persistence.Entity;

@Entity
public class TennisCourt extends Facility implements FacilityRacketFacade{
    private int nTennisRacquetsRented;
    private int nTennisBallsRented;

    public TennisCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                       int extraPriceForLightUse, int nRacquetsRented, int nTennisBallsRented) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNRacketsRented(nRacquetsRented);
        setNBallsRented(nTennisBallsRented);
    }

    public int getNRacketsRented() {
        return nTennisRacquetsRented;
    }

    public void setNRacketsRented(int nRacquetsRented) {
        if(nRacquetsRented < 0 || nRacquetsRented > 4)
            throw new IllegalArgumentException("The number of rented racquets cannot be over 4 or under 0");
        this.nTennisRacquetsRented = nRacquetsRented;
    }

    public int getNBallsRented() {
        return nTennisBallsRented;
    }

    public void setNBallsRented(int nTennisBallsRented) {
        if(nTennisBallsRented < 0 || nTennisBallsRented > 10)
            throw new IllegalArgumentException("The number of rented tennis balls cannot be over 10 or under 0");
        this.nTennisBallsRented = nTennisBallsRented;
    }

    @Override
    public String toString() {
        return "TennisCourt{" +
                "NTennisRacquetsRented=" + getNRacketsRented() +
                ", NTennisBallsRented=" + getNBallsRented() +
                ", facilityCode='" + getFacilityCode() + '\'' +
                ", maxCapacity=" + getMaxCapacity() +
                ", pricePerHour=" + getPricePerHour() +
                ", numberOfChangingRooms=" + getNumberOfChangingRooms() +
                ", numberOfFloodLights=" + getNumberOfFloodLights() +
                ", extraPriceForLightUse=" + getExtraPriceForLightUse() +
                ", reservations=" + getReservations() +
                '}';
    }
    @Override
    public String AvailableString() {
        return "Tennis Court (code: " + getFacilityCode() +
                ")    Capacity-> " + getMaxCapacity() +
                "    Price per hour-> " + getPricePerHour() +
                "$    Number changing rooms-> " + getNumberOfChangingRooms() +
                "    Number of flood lights-> " + getNumberOfFloodLights() +
                "    Extra price for lights-> " + getExtraPriceForLightUse() +
                "$    Tennis racquets available-> " + getNRacketsRented() +
                "    Tennis balls available-> " + getNBallsRented() +"\n" +
                "Available hours: " ;
    }
    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNRacketsRented() + "-" + getNBallsRented() + "\n";

    }
}
