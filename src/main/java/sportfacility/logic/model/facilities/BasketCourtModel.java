package sportfacility.logic.model.facilities;

public class BasketCourtModel extends FacilityModel{
	
	
    private int nBasketballsRented;
    
    public BasketCourtModel(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                       int extraPriceForLightUse, int nBasketballsRented) 
    {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNBasketballsRented(nBasketballsRented);
    }

    public int getNBasketballsRented() 
    {
        return nBasketballsRented;
    }

    public void setNBasketballsRented(int nBasketballsRented) 
    {
        if(nBasketballsRented != 1 && nBasketballsRented != 0)
            throw new IllegalArgumentException("The number of rented basketballs cannot be over 1 or under 0");
        
        this.nBasketballsRented = nBasketballsRented;
    }
}
