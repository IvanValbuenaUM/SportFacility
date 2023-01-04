package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadelCourtTest {

    @Test
    void constructorTest()
    {
        new PadelCourt("AB12", 10, 50, 3, 20, 13, 3, 8);
    }
    
    @Test
    void nPadelBallsMoreTest()
    {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, 3, 20, 13, 3, 11)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    
    @Test
    void nPadelBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, 3, 20, 13, 3, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel balls cannot be over 4 or under 10"));
    }
    
    @Test
    void nPadelRacquetsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, 3, 20, 13, 5, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void nPadelRacquetsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new PadelCourt("AB12", 10, 50, 3, 20, 13, -1, 8)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented padel racquets cannot be over 4 or under 0"));
    }
    
    @Test
    void getNPadelRacquetsTest()
    {

        PadelCourt pc = new PadelCourt("AB12", 10, 50, 3, 20, 13, 2, 5);

        assertEquals(2, pc.getNRacketsRented());
    }
    
    @Test
    void getNPadelBallsRacquetsTest()
    {

        PadelCourt pc = new PadelCourt("AB12", 10, 50, 3, 20, 13, 2, 5);

        assertEquals(5, pc.getNBallsRented());
    }
}