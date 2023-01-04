package sportfacility.data.entities.facilities;

import javax.persistence.Entity;

@Entity
public class PadelCourt extends Facility implements FacilityRacketFacade{
    private int nPadelRacquets;
    private int nPadelBallsRacquets;
    public PadelCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                      int extraPriceForLightUse, int nPadelRacquets, int nPadelBallsRacquets) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNRacketsRented(nPadelRacquets);
        setNBallsRented(nPadelBallsRacquets);
    }

    public int getNRacketsRented() {
        return nPadelRacquets;
    }

    public void setNRacketsRented(int nPadelRacquets) {
        if(nPadelRacquets < 0 || nPadelRacquets > 4)
            throw new IllegalArgumentException("The number of rented padel racquets cannot be over 4 or under 0");
        this.nPadelRacquets = nPadelRacquets;
    }

    public int getNBallsRented() {
        return nPadelBallsRacquets;
    }

    public void setNBallsRented(int nPadelBallsRacquets) {
        if(nPadelBallsRacquets < 0 || nPadelBallsRacquets > 10)
            throw new IllegalArgumentException("The number of rented padel balls cannot be over 4 or under 10");
        this.nPadelBallsRacquets = nPadelBallsRacquets;
    }

    @Override
    public String toString() {
        return "PadelCourt{" +
                "NPadelRacquets=" + getNRacketsRented() +
                ", NPadelBallsRacquets=" + getNBallsRented() +
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
        return "Padel Court (code: " + getFacilityCode() +
                ")    Capacity-> " + getMaxCapacity() +
                "    Price per hour-> " + getPricePerHour() +
                "$    Number changing rooms-> " + getNumberOfChangingRooms() +
                "    Number of flood lights-> " + getNumberOfFloodLights() +
                "    Extra price for lights-> " + getExtraPriceForLightUse() +
                "$    Padel racquets available-> " + getNRacketsRented() +
                "    Padel available available-> " + getNBallsRented() +"\n" +
                "Available hours: " ;
    }
    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNRacketsRented() + "-" + getNBallsRented() + "\n";

    }
}
