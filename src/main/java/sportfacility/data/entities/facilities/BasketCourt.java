package sportfacility.data.entities.facilities;

import sportfacility.data.entities.Days;

import java.util.HashMap;

import javax.persistence.Entity;

@Entity
public class BasketCourt extends Facility{
    private int nBasketballsRented;
    public BasketCourt(String facilityCode, int maxCapacity, int pricePerHour, HashMap<Days, Integer> closedDays, int numberOfChangingRooms, int numberOfFloodLights,
                       int extraPriceForLightUse, int nBasketballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, closedDays, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNBasketballsRented(nBasketballsRented);
    }

    public int getNBasketballsRented() {
        return nBasketballsRented;
    }

    public void setNBasketballsRented(int nBasketballsRented) {
        if(nBasketballsRented != 1 && nBasketballsRented != 0)
            throw new IllegalArgumentException("The number of rented basketballs cannot be over 1 or under 0");
        this.nBasketballsRented = nBasketballsRented;
    }

    @Override
    public String toString() {
        return "BasketCourt{" +
                "NBasketballsRented=" + getNBasketballsRented() +
                ", facilityCode='" + getFacilityCode() + '\'' +
                ", maxCapacity=" + getMaxCapacity() +
                ", pricePerHour=" + getPricePerHour() +
                ", closedDays=" + getClosedDays() +
                ", numberOfChangingRooms=" + getNumberOfChangingRooms() +
                ", numberOfFloodLights=" + getNumberOfFloodLights() +
                ", extraPriceForLightUse=" + getExtraPriceForLightUse() +
                ", reservations=" + getReservations() +
                '}';
    }

    @Override
    public String AvailableString() {
        return "Basketball Court Nº1 (code: " + getFacilityCode() +
                "    Capacity-> " + getMaxCapacity() +
                "    Price per hour-> " + getPricePerHour() +
                "$    Number changing rooms-> " + getNumberOfChangingRooms() +
                "    Number of flood lights-> " + getNumberOfFloodLights() +
                "    Extra price for lights-> " + getExtraPriceForLightUse() +
                "$    Basketballs available-> " + getNBasketballsRented() + "\n" +
                "Timetable....";
    }
}
