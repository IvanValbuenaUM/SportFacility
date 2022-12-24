package sportfacility.data.facilities;

import org.junit.jupiter.api.Test;
import sportfacility.data.Days;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FootballCourtTest {

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

        new FootballCourt("AB12", 10, 50, closedDays, 3, 20, 13, 0);
    }
    @Test
    void nFootBallsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourt("AB12", 10, 50, closedDays, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
    @Test
    void nFootBallsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourt("AB12", 10, 50, closedDays, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
}