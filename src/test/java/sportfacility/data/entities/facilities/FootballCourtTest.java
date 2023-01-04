package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballCourtTest {

    @Test
    void constructorTest()
    {
        new FootballCourt("AB12", 10, 50, 3, 20, 13, 0);
    }
    @Test
    void nFootBallsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourt("AB12", 10, 50, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
    @Test
    void nFootBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourt("AB12", 10, 50, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
    
    @Test
    void getNFootballsRentedTest()
    {
        FootballCourt fc = new FootballCourt("AB12", 10, 50, 3, 20, 13, 1);

        assertEquals(1, fc.getNBallsRented());
    }
}