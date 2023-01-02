package sportfacility.logic.model.facilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketCourtModelTest {

    @Test
    void constructorTest()
    {

        new BasketCourtModel("AB12", 10, 50, 3, 20, 13, 0);
    }
    
    @Test
    void nBasketBallsMoreTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourtModel("AB12", 10, 50, 3, 20, 13, -1)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void nBasketBallsLessTest()
    {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BasketCourtModel("AB12", 10, 50, 3, 20, 13, 2)
        );

        assertTrue(thrown.getMessage().contentEquals("The number of rented basketballs cannot be over 1 or under 0"));
    }
    
    @Test
    void getNBasketBallsRentedTest()
    {

        BasketCourtModel bc = new BasketCourtModel("AB12", 10, 50, 3, 20, 13, 1);

        assertEquals(1, bc.getNBasketballsRented());
    }
}