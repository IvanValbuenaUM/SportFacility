package sportfacility.data.entities.facilities;


import javax.persistence.Entity;

@Entity
public class FootballCourt extends Facility implements FacilityBallFacade{

    private int nFootballsRented;
    public FootballCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                         int extraPriceForLightUse, int nFootballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNBallsRented(nFootballsRented);
    }

    @Override
    public int getNBallsRented() {
        return nFootballsRented;
    }

    @Override
    public void setNBallsRented(int nFootballsRented) {
        if(nFootballsRented != 1 && nFootballsRented != 0)
            throw new IllegalArgumentException("The number of rented footballs cannot be over 1 or under 0");
        this.nFootballsRented = nFootballsRented;
    }

    @Override
    public String toString() {
        return "FootballCourt{" +
                "NFootballsRented=" + getNBallsRented() +
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
        return "Football Court (code: " + getFacilityCode() +
                ")    Capacity-> " + getMaxCapacity() +
                "    Price per hour-> " + getPricePerHour() +
                "$    Number changing rooms-> " + getNumberOfChangingRooms() +
                "    Number of flood lights-> " + getNumberOfFloodLights() +
                "    Extra price for lights-> " + getExtraPriceForLightUse() +
                "$    Footballs available-> " + getNBallsRented() + "\n" +
                "Available hours: " ;
    }
    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNBallsRented() + "\n";

    }
}
