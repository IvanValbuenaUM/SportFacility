package sportfacility.data.entities.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketCourtTest {

    @Test
    void constructorTest()
    {

        new BasketCourt("AB12", 10, 50, 3, 20, 13, 0);
    }
    
    @Test
    void nBasketBallsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourt("AB12", 10, 50, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void nBasketBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourt("AB12", 10, 50, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void getNBasketBallsRentedTest()
    {
        BasketCourt bc = new BasketCourt("AB12", 10, 50, 3, 20, 13, 1);

        assertEquals(1, bc.getNBallsRented());
    }
}