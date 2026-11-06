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

        if(isNull() || getSize() == 0){
            return;
        }
        Node tempNode = this.head;
        while (tempNode != null){
           System.out.println(String.format("The node val:%d and name: %s",tempNode.value, tempNode.name));
           tempNode = tempNode.next;
        }
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
    public boolean doesNodeExist(Node node){
        // MAKE SURE THE NODE BEING PASSED ISNT NULL
        //MAKE SURE HEAD IS NOT NULL
        if(isNull() || getSize() == 0){
            return false;
        }
        if (!nodeIsValid(node)){
            return false;
        }
        Node tempNode = this.head;
        while(tempNode != null){
            // if this node isntr nmull and equal to Node that is pased in does node exist then it exists :)
            if (tempNode == node){
                System.out.println("it does");
                return true;
            }
            tempNode = tempNode.next;
        }
        System.out.println("it doesnt");
        return false;
    }

    public static void main(String[] args){
        LinkedList LL = new LinkedList();
        Node nodeOne = new Node(3, "Penis");
        Node nodeTwo = new Node(4, "Butt");
        Node nodeThree = new Node(5, "JasonIsNeverGettingACat");
        Node nodeFour = new Node(5, "JasonIsNeverGettingACat");
        LL.add(nodeOne);
        LL.add(nodeTwo);
        LL.add(nodeThree);
        LL.printAllElements();
        LL.doesNodeExist(nodeTwo);
        LL.doesNodeExist(nodeFour);

    }



}
