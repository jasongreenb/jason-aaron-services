package com.example;


public class Node {
    public int value;
    public String name;
    public Node next;

    public Node(int value, String name) {
        this.value = value;
        this.name = name;
        this.next = null;
    }

    public void setNext(Node nextNode) {
        if(nextNode != null) {
            this.next = nextNode;
        }

    }
}
