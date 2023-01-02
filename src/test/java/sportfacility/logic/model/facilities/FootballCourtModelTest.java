package sportfacility.logic.model.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballCourtModelTest {

    @Test
    void constructorTest()
    {

        new FootballCourtModel("AB12", 10, 50, 3, 20, 13, 0);
    }
    @Test
    void nFootBallsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourtModel("AB12", 10, 50, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
    @Test
    void nFootBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FootballCourtModel("AB12", 10, 50, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented footballs cannot be over 1 or under 0"));
    }
    
    @Test
    void getNFootballsRentedTest()
    {

        FootballCourtModel fc = new FootballCourtModel("AB12", 10, 50, 3, 20, 13, 1);

        assertEquals(1, fc.getNFootballsRented());
    }
}