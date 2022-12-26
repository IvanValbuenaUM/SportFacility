package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import sportfacility.data.entities.Days;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BasketCourtTest {

    @Test
    void constructorTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        closedDays.put(Days.MONDAY, 0);
        closedDays.put(Days.MONDAY, 6);
        closedDays.put(Days.TUESDAY, 0);
        closedDays.put(Days.TUESDAY, 6);
        closedDays.put(Days.WEDNESDAY, 0);
        closedDays.put(Days.WEDNESDAY, 6);
        closedDays.put(Days.THURSDAY, 0);
        closedDays.put(Days.THURSDAY, 6);
        closedDays.put(Days.FRIDAY, 0);
        closedDays.put(Days.FRIDAY, 6);
        closedDays.put(Days.SATURDAY, 0);
        closedDays.put(Days.SATURDAY, 6);
        closedDays.put(Days.SUNDAY, -1);

        new BasketCourt("AB12", 10, 50, closedDays, 3, 20, 13, 0);
    }
    
    @Test
    void nBasketBallsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourt("AB12", 10, 50, closedDays, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void nBasketBallsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourt("AB12", 10, 50, closedDays, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void getNBasketBallsRentedTest()
    {
    	HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        closedDays.put(Days.MONDAY, 0);
        closedDays.put(Days.MONDAY, 6);
        closedDays.put(Days.TUESDAY, 0);
        closedDays.put(Days.TUESDAY, 6);
        closedDays.put(Days.WEDNESDAY, 0);
        closedDays.put(Days.WEDNESDAY, 6);
        closedDays.put(Days.THURSDAY, 0);
        closedDays.put(Days.THURSDAY, 6);
        closedDays.put(Days.FRIDAY, 0);
        closedDays.put(Days.FRIDAY, 6);
        closedDays.put(Days.SATURDAY, 0);
        closedDays.put(Days.SATURDAY, 6);
        closedDays.put(Days.SUNDAY, -1);

        BasketCourt bc = new BasketCourt("AB12", 10, 50, closedDays, 3, 20, 13, 1);

        assertEquals(1, bc.getNBasketballsRented());
    }
}