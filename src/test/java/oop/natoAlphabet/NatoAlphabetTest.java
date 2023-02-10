package oop.natoAlphabet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

import org.junit.jupiter.api.Test;

public class NatoAlphabetTest {
  
    @Test
    public void itShouldEncodeMessageHello() {
        String actual = NatoAlphabet.encode("hello");
        assertEquals("hotel-echo-lima-lima-oscar", actual);
    }

    @Test
    public void itShouldDecodeMessageIntoHello() {
        String actual = NatoAlphabet.decode("hotel-echo-lima-lima-oscar");
        assertEquals("hello", actual);
    }
    
    @Test
    public void itShouldParseWhiteSpacesAsNull() {
        String actual = NatoAlphabet.encode("khabib nurmagomedov");
        assertEquals("kilo-hotel-alpha-bravo-india-bravo-null-november-uniform-romeo-mike-alpha-golf-oscar-mike-echo-delta-oscar-victor", actual);
    }
    
    @Test
    public void itShouldThrowExceptionIfInputIsBlank() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            NatoAlphabet.encode("");
        });

        String expectedMessage = "\"\" input outside NATO alphabet";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void itShouldhThrowExceptionIfCharacterIsOutsideNatoAlphabet() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            NatoAlphabet.encode("+");
        });

        String expectedMessage = "\"+\" input outside NATO alphabet";

        assertEquals(expectedMessage, exception.getMessage());
    }






}
