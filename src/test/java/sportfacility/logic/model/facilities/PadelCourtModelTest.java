package sportfacility.logic.model.facilities;

import org.junit.jupiter.api.Test;

import sportfacility.logic.model.Days;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PadelCourtModelTest {

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

        new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 3, 8);
    }
    
    @Test
    void nPadelBallsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 3, 11)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    
    @Test
    void nPadelBallsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 3, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    
    @Test
    void nPadelRacquetsMoreTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 5, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void nPadelRacquetsLessTest()
    {
        HashMap<Days,Integer> closedDays = new HashMap<Days, Integer>();

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, -1, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void getNPadelRacquetsTest()
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

        PadelCourtModel pc = new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 2, 5);

        assertEquals(2, pc.getNPadelRacquets());
    }
    
    @Test
    void getNPadelBallsRacquetsTest()
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

        PadelCourtModel pc = new PadelCourtModel("AB12", 10, 50, closedDays, 3, 20, 13, 2, 5);

        assertEquals(5, pc.getNPadelBallsRacquets());
    }
}