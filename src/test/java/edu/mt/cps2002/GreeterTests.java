package edu.mt.cps2002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterTests {

    @Test
    public void testSimpleGreeting() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello World!!", greeter.greetMe());
    }

    @Test
    public void testGreetByName() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello Mark!!", greeter.greetMe("Mark"));
    }

    @Test
    public void testGreetByNameWithNull() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello World!!", greeter.greetMe(null));
    }

    public void testGreetByNameWithEmptyString() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello World!!", greeter.greetMe(""));
    }

    public void testGreetByNameWithWhitespace() {
        Greeter greeter = new Greeter();
        Assertions.assertEquals("Hello World!!", greeter.greetMe("    \t  "));
    }


}
