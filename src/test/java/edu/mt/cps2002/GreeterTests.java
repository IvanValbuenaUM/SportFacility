package edu.mt.cps2002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterTests {

    @Test
    public void testSimpleGreeting() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello World!!", greeter.greetMe());
    }

}
