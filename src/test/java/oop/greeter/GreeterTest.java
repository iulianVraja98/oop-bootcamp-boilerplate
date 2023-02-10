package oop.greeter;

import oop.greeter.Greeter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {

    private Greeter greeter;

    @BeforeEach
    public void setUp(){
      greeter=new Greeter(LocalTime.parse("05:00:00"));
    }
    @Test
    public void itShouldWriteHelloPlusInputName() {
        assertEquals( "Hello John",greeter.greet("John"));
    }

    @Test
    public void itShouldTrimTheInput() {
        assertEquals("Hello John",greeter.greet(" John "));
    }

    @Test
    public void itShouldCapitalizeFirstLetter() {
        assertEquals("Hello John",greeter.greet("john"));
    }

    @Test
    public void itShouldReturnGoodMorning() {
        final Greeter morningGreeter = new Greeter(LocalTime.parse("07:00:00"));
        assertEquals("Good morning John",morningGreeter.greet("John"));
    }
    @Test
    public void itShouldReturnGoodEvening() {
        final Greeter morningGreeter = new Greeter(LocalTime.parse("19:00:00"));
        assertEquals("Good evening John",morningGreeter.greet("John"));
    }

}
//    Write a Greeter class with greet function that receives a name as input and outputs Hello <name>. The signature of greet should not change throughout the kata. You are allowed to construct Greeter objects as you please.
//        greet trims the input
//        greet capitalizes the first letter of the name
//        greet returns Good morning <name> when the time is 06:00-12:00
//        greet returns Good evening <name> when the time is 18:00-22:00
//        greet returns Good night <name> when the time is 22:00-06:00