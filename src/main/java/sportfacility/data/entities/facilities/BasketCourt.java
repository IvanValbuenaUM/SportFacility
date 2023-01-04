package sportfacility.data.entities.facilities;

import javax.persistence.Entity;

@Entity
public class BasketCourt extends Facility implements FacilityBallFacade{
    private int nBasketballsRented;
    public BasketCourt(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                       int extraPriceForLightUse, int nBasketballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNBallsRented(nBasketballsRented);
    }

    @Override
    public int getNBallsRented() {
        return nBasketballsRented;
    }

    @Override
    public void setNBallsRented(int nBasketballsRented) {
        if(nBasketballsRented != 1 && nBasketballsRented != 0)
            throw new IllegalArgumentException("The number of rented basketballs cannot be over 1 or under 0");
        this.nBasketballsRented = nBasketballsRented;
    }

    @Override
    public String toString() {
        return "BasketCourt{" +
                "NBasketballsRented=" + getNBallsRented() +
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
                "$    Basketballs available-> " + getNBallsRented() + "\n" +
                "Available hours: " ;
    }

    @Override
    public String serialize() {
        return getFacilityCode() + "-" + getMaxCapacity() + "-" + getPricePerHour() + "-" + getNumberOfChangingRooms() + "-" + getNumberOfFloodLights() +
                "-" + getExtraPriceForLightUse() + "-" + getNBallsRented() + "\n";

    }
}
