package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import sportfacility.data.entities.Days;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TennisCourtTest {
	
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

        new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, 8);
    }
    
    @Test
    void nTennisBallsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, 11)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented tennis balls cannot be over 10 or under 0"));
    }
    
    @Test
    void nTennisBallsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented tennis balls cannot be over 10 or under 0"));
    }
    
    @Test
    void nTennisRacquetsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 5, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void nTennisRacquetsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, -1, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void getNTennisRacquetsRentedTest()
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

        TennisCourt tc = new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 2, 5);

        assertEquals(2, tc.getNTennisRacquetsRented());
    }
    
    @Test
    void getNTennisBallsRentedTest()
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

        TennisCourt tc = new TennisCourt("AB12", 10, 50, closedDays, 3, 20, 13, 2, 5);

        assertEquals(5, tc.getNTennisBallsRented());
    }
}