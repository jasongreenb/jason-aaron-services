package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp(){
        queue = new Queue<>();
    }

    @Test
    @DisplayName("Testing enqueue")
    void testEnqueue(){
        queue.enqueue("Hello");
        assertEquals("Hello", queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        Queue<String> newQueue2 = new Queue<>();
        newQueue2.enqueue("SupBrah");
        newQueue2.enqueue(null);
        assertEquals(1, newQueue2.size());

    }
    @Test
    @DisplayName("Testing dequeue")
    void testDequeue(){
        queue.enqueue("Hello");
        queue.enqueue("Banana");
        assertEquals("Hello", queue.dequeue());
        assertEquals("Banana", queue.peek());
        assertEquals(1, queue.size());
        //
        Queue<String> thirdQueue = new Queue<>();
        assertEquals(null, thirdQueue.dequeue());
    }
    @Test
    @DisplayName("Testing peek")
    void testPeek(){
        queue.enqueue("FirstItem");
        queue.enqueue("SecondItem");
        queue.enqueue("ThirdItem");
        assertEquals(3,queue.size());
        assertEquals("FirstItem", queue.peek());
        //
        Queue<String> newQueue = new Queue<>();
        assertEquals(null, newQueue.peek());



    }


}
