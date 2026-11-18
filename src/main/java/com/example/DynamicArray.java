package com.example;

public class DynamicArray {
    public int[] data;
    public int size;

    public DynamicArray( int initialCapacity){
        data = new int[initialCapacity];
        size = 0;
    }

    public int get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("The Index You Passed Is Too Big");
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException("The Index You Passed Is Too Small");
        }
        else{
            return data[index];
        }
    }



    public void set(int index, int element){
        if(index >= size){
            throw new IndexOutOfBoundsException("The Index You Passed Is Too Big");
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException("The Index You Passed Is Too Small");
        }
        else{
            data[index] = element;
        }
    }


    public void resize(){
        int[] copyArray = new int[data.length * 2];

        for(int i = 0; i < this.size; i++){
            copyArray[i] = data[i];
        }
        data = copyArray;
    }


    public void insert(int element){
        if(data.length == size){
            resize();
        }
            data[size] = element;
            size ++;

        }
    }
