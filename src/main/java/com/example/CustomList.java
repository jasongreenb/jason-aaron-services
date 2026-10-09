package com.example;

public class CustomList<T>
{

    public static void main(String[] args) {
        CustomList<String> myCustomList = new CustomList<String>();
        String greeting = myCustomList.getFirstObject();
        System.out.println(greeting);
    }


    private final Object[] data;

    public T[] getData() {
        return (T[])this.data;
    }

    public CustomList() {
        this.data = new Object[10];
        this.data[0] = "hello my friend";
    }

    public T getFirstObject() {
        if(data[0] != null) {
            return (T)data[0];
        }
        return null;
    }
}
