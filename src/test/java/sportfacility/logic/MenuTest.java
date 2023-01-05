package sportfacility.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test
    void getInstanceTest()
    {
        Menu menu;
        menu = Menu.getInstance();
        assertNotEquals(menu, null);
    }

}