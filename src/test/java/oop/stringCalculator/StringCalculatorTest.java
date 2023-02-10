package oop.stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void itShouldReturn0WhenStringIsEmpty() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(0, stringCalculator.calculateSumOfNumbers(""));
    }

    @Test
    public void itShouldReturnNumber() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(2, stringCalculator.calculateSumOfNumbers("2"));
    }

    @Test
    public void itShouldReturnSumOfNumbersWhenDelimitedByComma() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(4, stringCalculator.calculateSumOfNumbers("2,2"));
    }

    @Test
    public void itShouldReturnSumOfNumbersWhenDelimitedByEndLine() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(4, stringCalculator.calculateSumOfNumbers("2\n2"));
    }

    @Test
    public void itShouldReturnSumOfNumbersWhenDelimitedByEndLineAndComma() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(10, stringCalculator.calculateSumOfNumbers("1\n2,3\n4"));
    }

//    @Test
//    public void itShouldThrowAnExceptionWhenNegativeNumbers() {
//        StringCalculator stringCalculator = new StringCalculator();
//        Exception exception = assertThrows(Exception.class, () -> {
//            stringCalculator.calculateSumOfNumbers("-11\n2,3\n-4");
//        });
//
//        String expectedMessage = "negatives not allowed: -11,-4'";
//
//        assertEquals(expectedMessage, exception.getMessage());
//    }
}
