package sportfacility.data.facilities;

import sportfacility.data.Days;

import java.util.HashMap;

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
}
