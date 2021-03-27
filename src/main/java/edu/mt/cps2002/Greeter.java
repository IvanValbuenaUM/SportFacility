package edu.mt.cps2002;

public class Greeter {

    public String greetMe() {
        return "Hello World!!";
    }

    public String greetMe(String name) {
        if (name != null && name.trim().length() > 0) {
            return "Hello " + name + "!!";
        } else {
            return greetMe();
        }
    }


}
