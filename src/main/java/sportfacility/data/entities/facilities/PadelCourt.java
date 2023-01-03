package sportfacility.data.entities.facilities;

import javax.persistence.Entity;

@Entity
public class PadelCourt extends Facility{
    private int nPadelRacquets;
    private int nPadelBallsRacquets;
    public PadelCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                      int extraPriceForLightUse, int nPadelRacquets, int nPadelBallsRacquets) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNPadelRacquets(nPadelRacquets);
        setNPadelBallsRacquets(nPadelBallsRacquets);
    }

    public int getNPadelRacquets() {
        return nPadelRacquets;
    }

    public void setNPadelRacquets(int nPadelRacquets) {
        if(nPadelRacquets < 0 || nPadelRacquets > 4)
            throw new IllegalArgumentException("The number of rented padel racquets cannot be over 4 or under 0");
        this.nPadelRacquets = nPadelRacquets;
    }

    public int getNPadelBallsRacquets() {
        return nPadelBallsRacquets;
    }

    public void setNPadelBallsRacquets(int nPadelBallsRacquets) {
        if(nPadelBallsRacquets < 0 || nPadelBallsRacquets > 10)
            throw new IllegalArgumentException("The number of rented padel balls cannot be over 4 or under 10");
        this.nPadelBallsRacquets = nPadelBallsRacquets;
    }

    @Override
    public String toString() {
        return "PadelCourt{" +
                "NPadelRacquets=" + getNPadelRacquets() +
                ", NPadelBallsRacquets=" + getNPadelBallsRacquets() +
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
        return "Basketball Court (code: " + getFacilityCode() +
                ")    Capacity-> " + getMaxCapacity() +
                "    Price per hour-> " + getPricePerHour() +
                "$    Number changing rooms-> " + getNumberOfChangingRooms() +
                "    Number of flood lights-> " + getNumberOfFloodLights() +
                "    Extra price for lights-> " + getExtraPriceForLightUse() +
                "$    Padel racquets available-> " + getNPadelRacquets() +
                "    Padel available available-> " + getNPadelBallsRacquets() +"\n" +
                "Available hours: " ;
    }
    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNPadelRacquets() + "-" + getNPadelBallsRacquets() + "\n";

    }
}
