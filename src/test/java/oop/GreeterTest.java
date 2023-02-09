package oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {

    private Greeter greeter;

    @BeforeEach
    public void setUp(){
      greeter=new Greeter();
    }
    @Test
    public void itShouldWriteHelloPlusInputName() {
        assertEquals( "Hello Dani",greeter.greet("Dani"));
    }

    @Test
    public void itShouldTrimTheInput() {
        assertEquals("Hello Dani",greeter.greet(" Dani "));
    }

    @Test
    public void itShouldCapitalizeFirstLetter() {
        assertEquals("Hello Dani",greeter.greet(" dani "));
    }

    @Test
    public void itShouldReturnGoodMorning() {
        greeter.setTime("06:00-12:00");
        assertEquals("Hello Dani",greeter.greet(" dani "));
    }





}
//    Write a Greeter class with greet function that receives a name as input and outputs Hello <name>. The signature of greet should not change throughout the kata. You are allowed to construct Greeter objects as you please.
//        greet trims the input
//        greet capitalizes the first letter of the name
//        greet returns Good morning <name> when the time is 06:00-12:00
//        greet returns Good evening <name> when the time is 18:00-22:00
//        greet returns Good night <name> when the time is 22:00-06:00