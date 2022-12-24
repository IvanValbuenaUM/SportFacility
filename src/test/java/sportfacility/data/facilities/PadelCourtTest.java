package sportfacility.data.facilities;

import org.junit.jupiter.api.Test;
import sportfacility.data.Days;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PadelCourtTest {

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

        new PadelCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, 8);
    }
    @Test
    void nPadelBallsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, 11)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    @Test
    void nPadelBallsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, closedDays, 3, 20, 13, 3, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    @Test
    void nPadelRacquetsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, closedDays, 3, 20, 13, 5, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
    @Test
    void nPadelRacquetsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, closedDays, 3, 20, 13, -1, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
}