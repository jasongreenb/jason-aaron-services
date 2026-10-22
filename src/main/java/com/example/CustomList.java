package com.example;
import java.util.Arrays;





public class CustomList<E> {



    // --- Fields ---
    private static final int DEFAULT_CAPACITY = 2;
    public int currentCapacity;
    public Object[] data;
    public int size; // Tracks the number of actual elements stored


    // --- Constructors ---
    public CustomList() {
        this.currentCapacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public CustomList(int initialCapacity) {
        this.currentCapacity = initialCapacity;
        this.size = 0;
        this.data = new Object[initialCapacity];

    }

    public void printCurrentCapacity() {
        System.out.println(String.format("The current capacity is at %d ", this.currentCapacity));
    }

    private boolean isFull() {
        return this.size == this.currentCapacity;
    }

    private void resize() {
        //  copyArray = Arrays.copyOf(oldArray, numberOfElementsToCopyOver)

        Object[] copyArray = Arrays.copyOf(this.data, this.currentCapacity);

        for (int i = 0; i < this.currentCapacity; i++) {
            this.data[i] = null;
        }

        this.currentCapacity *= 2;
        this.data = new Object[this.currentCapacity];


        for (int i = 0; i < this.size; i++) {
            this.data[i] = copyArray[i];
            copyArray[i] = null;

        }

        copyArray = null;


    }

    public void add(E e) {

        if (isFull()) {
            resize();

            this.data[this.size] = e;
            this.size += 1;


        } else {

            // next open slot == size

            this.data[this.size] = e;
            this.size += 1;

        }

        // iterate through all the indexes
        // in each box, if it is null you can add it
        // if it is not null, continue to the next spot


        // if it is full
        // we need to resize()
    }

    public E get(int index) {
        // index = 69
        if (isIndexInBounds(index)) {
            return (E) this.data[index - 1];
        } else {
            System.out.println("YOU FUCKING PASSED TOO BIG OR TOO SMALL OF AN INDEX!");
            return null;
        }

    }

    public boolean isIndexInBounds(int index) {
        return index >= 0 && index <= this.currentCapacity - 1;
    }

    public void set(int index, E element) {

        if(isIndexInBounds(index)) {

            if(this.data[index-1] == null) {
                System.out.println("WE ARE IN THE SET FUNCTION, THIS SPOT WAS EMPTY!");
                this.data[index - 1] = element;
                this.size += 1;
            } else {
                System.out.println("WE ARE IN THE SET FUNCTION, THIS SPOT WAS NOT EMPTY LOL!");
                this.data[index - 1] = element;
            }

        }


    }

    public E remove(int index) {
        return null;
    }

    public int size() {
        return this.size;
    }

    public void printSize() {
        System.out.println(String.format("The arrays size is: %d", this.size));
    }

    public void printEverything() {
        for(int i = 0; i < this.currentCapacity; i++) {
            System.out.println(String.format("String @%d , is: %s", i + 1 , this.data[i]));
        }
    }



    public static void main(String[] args) {
        CustomList<String> customListObject1 = new CustomList<>();
        CustomList<String> customListObject2 = new CustomList<>(5);

        for(int i = 1; i <= 99; i++) {
            customListObject1.add("Hello" + i);
        }

        customListObject1.printSize(); // 99
        customListObject1.printCurrentCapacity(); // 128
        customListObject1.set(107, "HelloYouStupidBitch");
        String objectAtPosition107 = customListObject1.get(107);
        System.out.println(String.format("Object at position 107: %s", objectAtPosition107));
        customListObject1.printSize(); // 100
        customListObject1.set(107, "HelloYouStupidBitchNEWVERISIONLOL");
        objectAtPosition107 = customListObject1.get(107);
        System.out.println(String.format("Object at position 107: %s", objectAtPosition107));

        customListObject1.printEverything();




    }


}