package com.example;

import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> data;


    // Constructor
    public Queue() {
        // Nothing implemented yet
        this.data = new ArrayList<T>();
    }

    // Adds an item to the back (end) of the queue
    public void enqueue(T item) {
        if(isNull(item)){
            return;
        }
        this.data.add(item);
    }


    public boolean isNull(T item){
        return item == null;
    }


    // Removes and returns the item at the front of the queue
    public T dequeue() {
        // Nothing implemented yet
        if(this.data.isEmpty()){
            return null;
        }

        return this.data.remove(0);
    }

    // Looks at the front item without removing it
    public T peek() {
        // Nothing implemented yet
        if(this.data.isEmpty()) {
            return null;
        }
        return this.data.get(0);
    }





    // Checks if the queue has no items
    public boolean isEmpty(){return this.data.size()== 0;}

    // Returns the total number of items
    public int size() {
        return this.data.size();
    }
}
