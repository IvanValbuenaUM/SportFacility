package sportfacility.logic.model.facilities;

public class PadelCourtModel extends FacilityModel{
	
	
    private int nPadelRacquets;
    private int nPadelBallsRacquets;
    public PadelCourtModel(String facilityCode, int maxCapacity, int pricePerHour, int numberOfChangingRooms, int numberOfFloodLights,
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
}
