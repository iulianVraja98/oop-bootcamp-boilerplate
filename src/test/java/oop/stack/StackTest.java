package oop.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void itShouldPushElement() {

        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void itShouldReturnTrueWhenEmptyStack() {

        assertTrue(stack.isEmpty());
    }

    @Test
    public void itShouldPopElement() {

        stack.push("A");
        String actualElement = stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals("A", actualElement);
    }

    @Test
    public void itShouldGetPeek() {

        stack.push("A");
        String actualElement = stack.peek();

        assertEquals("A", actualElement);
        assertFalse(stack.isEmpty());
    }

}
