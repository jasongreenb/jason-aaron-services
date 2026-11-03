package com.example;

import java.util.ArrayList;

public class Queue<T> {

    ArrayList<T> data;


    // Constructor
    public Queue() {
        // Nothing implemented yet
        this.data = new ArrayList<T>();
    }

    // Adds an item to the back (end) of the queue
    public void enqueue(T item) {
        // Nothing implemented yet
    }

    // Removes and returns the item at the front of the queue
    public T dequeue() {
        // Nothing implemented yet
        // check is it empty

        this.data.remove(0);
        return null;
    }

    // Looks at the front item without removing it
    public T peek() {
        // Nothing implemented yet
        return null;
    }

    // Checks if the queue has no items
    public boolean isEmpty() {
        // Nothing implemented yet
        return false;
    }

    // Returns the total number of items
    public int size() {
        // Nothing implemented yet
        return 0;
    }
}
