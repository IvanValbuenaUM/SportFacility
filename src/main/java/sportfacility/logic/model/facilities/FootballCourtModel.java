package sportfacility.logic.model.facilities;

public class FootballCourtModel extends FacilityModel {

    private int nFootballsRented;

    public FootballCourtModel(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
                              int extraPriceForLightUse, int nFootballsRented) {
        super(facilityCode, maxCapacity, pricePerHour, numberOfChangingRooms, numberOfFloodLights, extraPriceForLightUse);
        setNFootballsRented(nFootballsRented);
    }

    public int getNFootballsRented() {
        return nFootballsRented;
    }

    public void setNFootballsRented(int nFootballsRented) {
        if (nFootballsRented != 1 && nFootballsRented != 0)
            throw new IllegalArgumentException("The number of rented footballs cannot be over 1 or under 0");
        this.nFootballsRented = nFootballsRented;
    }
}
