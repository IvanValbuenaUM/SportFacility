package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisCourtTest {
	
    @Test
    void constructorTest()
    {

        new TennisCourt("AB12", 10, 50, 3, 20, 13, 3, 8);
    }
    
    @Test
    void nTennisBallsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, 3, 20, 13, 3, 11)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented tennis balls cannot be over 10 or under 0"));
    }
    
    @Test
    void nTennisBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, 3, 20, 13, 3, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented tennis balls cannot be over 10 or under 0"));
    }
    
    @Test
    void nTennisRacquetsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, 3, 20, 13, 5, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void nTennisRacquetsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TennisCourt("AB12", 10, 50, 3, 20, 13, -1, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void getNTennisRacquetsRentedTest()
    {

        TennisCourt tc = new TennisCourt("AB12", 10, 50, 3, 20, 13, 2, 5);

        assertEquals(2, tc.getNTennisRacquetsRented());
    }
    
    @Test
    void getNTennisBallsRentedTest()
    {

        TennisCourt tc = new TennisCourt("AB12", 10, 50, 3, 20, 13, 2, 5);

        assertEquals(5, tc.getNTennisBallsRented());
    }
}