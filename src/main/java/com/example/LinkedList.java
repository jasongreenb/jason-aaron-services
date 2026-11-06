package com.example;


public class LinkedList {
    Node head;
    int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(Node node) {
        // is this LinkedList empty
        if(!nodeIsValid(node)){
            return;
        }
        if(isNull() || getSize() == 0){
            this.head = node;
            this.size += 1;
            return;
        }
        Node tempNode = this.head;
        while (tempNode.next != null){
            tempNode = tempNode.next;

        }
        tempNode.setNext(node);
        this.size += 1;

        // iterate through with a "walker" variable until walker.Next is null
        // we have reached the last element so after the loop set
        // the walkers next to the item


        // increment size either way
    }

    public boolean nodeIsValid(Node node){
        return node != null;
    }

    public void printAllElements() {
        // start at head with a "walker" variable as long as head
        // is not null

        // while walker.next is not null
        // print walker.name, walker.value
        // set walker to walker.next
    }
    public boolean isNull(){
        return this.head == null;
    }

    public int getSize(){
        return this.size;
    }
    public static void main(String[] args){

    }

}
