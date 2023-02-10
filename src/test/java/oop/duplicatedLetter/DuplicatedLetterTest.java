package oop.duplicatedLetter;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatedLetterTest {

    @Test
    public void itShouldFindDuplicatedLetters() {

        List<String> stringList = List.of("a", "c", "a", "a", "d", "e", "c", "w");

        Set<String> actualDuplicatesSet = DuplicatedLetter.findDuplicates(stringList);
        Set<String> expectedSet = Set.of("a", "c");

        assertEquals(expectedSet, actualDuplicatesSet);
    }
}
