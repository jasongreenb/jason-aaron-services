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

    public boolean isFull() {
        return this.size == this.currentCapacity;
    }

    public boolean isEmpty() {return this.size == 0;}

    public void resize() {
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

    public void add(E element) {
        if(element == null) {
            return;
        }


        if (isFull()) {
            resize();

            this.data[this.size] = element;
            this.size += 1;


        } else {

            // next open slot == size



            if(element != null) {
                this.data[this.size] = element;
                this.size += 1;
            }


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
            return (E) this.data[index];
        } else {
            System.out.println("YOU FUCKING PASSED TOO BIG OR TOO SMALL OF AN INDEX!");
            return null;
        }

    }

    // 0 < index < size-1
    public boolean isIndexInBounds(int index) {
        return index >= 0 && index <= size() - 1;
    }


    public void set(int index, E element) {

        if(element == null) {
            return;
        }

        if(isIndexInBounds(index)) {
            this.data[index] = element;
        }

    }

    // returns the index of the passed element if it exists in the list else returns -1
    public int find(E element) {
        if(isEmpty()) {return -1;}


        for(int i = 0; i < this.size(); i++) {
            if (this.data[i] != null && this.data[i].equals(element) ) {
                return i;
            }
        }

        System.out.println("Item does not exist in list");
        return -1;

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

    public void remove(E element) {
        if(element == null) {
            System.out.println("Please Pass a valid elemnt\n");
            return;
        }

        // make sure list is not empty
        if( isEmpty() ) {
            System.out.println("EMPTY LIST!\n");
            return;
        }

        //1. Check if the element exists  - .find() which will return us the index where this element is
        int elementPosition = find(element);
        if (elementPosition == -1 ) {
            return;
        }

        if (size() == 1) {
            this.data[0] = null;
            this.size = 0;
            return;
        }


        // @elementPosition is our variable to delete, everything after it slides left one

        for (int i = elementPosition; i < size() - 1; i++) {
            if(this.data[i+1] != null) {
                this.data[i] = this.data[i+1];
            } else {
                this.data[i] = null;
                this.size--;
                return;
            }

        }

        this.data[size() - 1] = null;
        this.size--;



    }

// jasons current change

    public static void main(String[] args) {
        CustomList<String> emptyList = new CustomList<>();
        CustomList<String> listOfSizeOne = new CustomList<>(1);
        CustomList<String> listOfSizeTwo = new CustomList<>(2);
        CustomList<String> listOfContigousValuesSize4 = new CustomList<>(4);
        CustomList<String> listOfContigousValuesSize4LastOneIsNull = new CustomList<>(5);


//
//        emptyList.remove("hello");
//
//
//        listOfSizeOne.add("One");
//        listOfSizeOne.remove("One");
//        System.out.println("listOfSizeOne after removing One\n");
//        listOfSizeOne.printEverything();


        //        listOfSizeTwo.add("One");
        //listOfSizeTwo.add("Two");
//        listOfSizeOne.remove("One");
//        System.out.println("listOfSizeTwo after removing One\n");
//        listOfSizeOne.printEverything();

        //        listOfSizeTwo.add("One");
        //listOfSizeTwo.add("Two");
//        listOfSizeOne.remove("Two");
//        System.out.println("listOfSizeTwo after removing Two\n");
//        listOfSizeOne.printEverything();




//        listOfContigousValuesSize4.add("One");
//        listOfContigousValuesSize4.add("Two");
//        listOfContigousValuesSize4.add("Three");
//        listOfContigousValuesSize4.add("Four");
//        listOfContigousValuesSize4.remove("Four");
//        listOfContigousValuesSize4.printEverything();
//        listOfContigousValuesSize4.printSize();

        listOfContigousValuesSize4LastOneIsNull.add("One");
        listOfContigousValuesSize4LastOneIsNull.add("Two");
        listOfContigousValuesSize4LastOneIsNull.add("Three");
        listOfContigousValuesSize4LastOneIsNull.add("Four");
        listOfContigousValuesSize4LastOneIsNull.add(null);
        listOfContigousValuesSize4LastOneIsNull.remove("Four");
        listOfContigousValuesSize4LastOneIsNull.remove("One");
        listOfContigousValuesSize4LastOneIsNull.remove(null);
        listOfContigousValuesSize4LastOneIsNull.remove("Three");
        listOfContigousValuesSize4LastOneIsNull.printEverything();
        listOfContigousValuesSize4LastOneIsNull.printSize();












    }


}