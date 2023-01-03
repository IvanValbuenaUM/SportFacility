package sportfacility.data.entities.facilities;


import javax.persistence.Entity;

@Entity
public class FootballCourt extends Facility{

    private int nFootballsRented;
    public FootballCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                         int extraPriceForLightUse, int nFootballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
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

    @Override
    public String toString() {
        return "FootballCourt{" +
                "NFootballsRented=" + getNFootballsRented() +
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
                "$    Footballs available-> " + getNFootballsRented() + "\n" +
                "Available hours: " ;
    }
    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNFootballsRented() + "\n";

    }
}
