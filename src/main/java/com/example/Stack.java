package com.example;
import java.util.ArrayList;
import java.util.HashMap;

public class Stack<T> {

    private ArrayList<T> data;

    // Constructor
    public Stack() {
        this.data = new ArrayList<T>();
    }

    // Adds an item to the top of the stack
    public void push(T item) {
        if(isNull(item)) {
            return;
        }

        this.data.add(item);

    }

    public boolean isNull(T item) {
        return item == null;
    }

    // Removes and returns the top item
    public T pop() {
        if (!isEmpty()) {
            T itemFromTheBack = this.data.get(this.data.size() - 1);
            this.data.remove(itemFromTheBack);
            return itemFromTheBack;
        }

        return null;
    }

    // Looks at the top item without removing it
    public T peek() {
        if (!isEmpty()){
           return this.data.get(this.data.size()- 1);
        }
        return null;
    }

    // Gets the index of the item, returns -1 if it doesnt exist
    public int search(T item) {
        // Nothing implemented yet
        return 0;
    }



    // Checks if the stack has no items
    public boolean isEmpty() {
        return this.data.size() == 0;
    }

    // Returns the total number of items
    public int size() {
        // Nothing implemented yet
        return 0;
    }
}