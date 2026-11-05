package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack<String> stack;

    @BeforeEach
    void setUp() {stack = new Stack<>(); }

    @Test
    @DisplayName("Testing push")
    void testPush(){
        stack.push("Hello");
        assertEquals(1, stack.size());
        stack.push(null);
        assertEquals(1, stack.size());
        stack.push("Bob");
        assertEquals(2, stack.size());
    }
    @Test
    @DisplayName("Testing pop")
    void testPop(){
        assertEquals(null, stack.pop());
        stack.push("Hello");
        stack.push("Hello2");
        stack.push("Hello3");
        assertEquals("Hello3", stack.pop());
        assertEquals(2, stack.size());
    }
    @Test
    @DisplayName("Testing peek")
    void testPeek(){
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        stack.push("Item4");
        assertEquals(4, stack.size());
        assertEquals("Item4", stack.peek());
        assertEquals(4, stack.size());
    }

    @Test
    @DisplayName("Test search")
    void testSearch(){
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        stack.push("Item4");
        assertEquals(3, stack.search("Item4"));
        assertEquals(-1, stack.search("THIS SHOULDNT EXIST"));
    }
}
