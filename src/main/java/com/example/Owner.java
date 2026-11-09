package com.example;

public class Owner {
    public String name;
    public int age;
    public CustomList<Cat> petList;

    record Cat(String name, int age){}

    public Owner(String name, int age){
        this.name = name;
        this.age = age;
        petList = new CustomList<>();


    }

    public static void main(String[] args){
        Owner Jason = new Owner("Jason", 21);
        Cat Luna = new Cat("Luna", 5);
        Jason.addCat(Luna);
        System.out.println("The size is " + Jason.petList.size());
        System.out.println("the first cats name is" + Jason.catNameByIndex(0));



    }
    public void addCat(Cat cat){
        petList.add(cat);

    }


    public void removeCat(Cat cat){
        petList.remove(cat);
    }
    public String catNameByIndex(int index){
        Cat foundCat = petList.get(index);
        return foundCat.name;
    }

}

