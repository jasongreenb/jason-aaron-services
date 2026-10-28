package com.example;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class CustomSetOfCars  {

    public static void main(String[] args) {
        CustomSetOfCars cars = new CustomSetOfCars();
        cars.add(new CarRecord<String,Integer>("Chevy",2004));
        cars.add(new CarRecord<String,Integer>("Chevy",2003));
        cars.add(new CarRecord<String,Integer>("Chevy",2004));
        cars.printKeys();

        cars.add(null);
        cars.add(new CarRecord<>(null, 2018));
        cars.add(new CarRecord<>("Chevy", null));

        cars.printKeys();


    }
    // define what a car record is: CarRecord = <car,year>
    public record CarRecord<L,R>(L car, R year) {};

    // a map that holds CarRecord as the key with the value as 1 if that carRecord exists
    HashMap<CarRecord<String,Integer>, Integer> cars;

    public CustomSetOfCars(){
        this.cars = new HashMap<>();

    }


    public boolean carRecordIsValid(CarRecord<String,Integer> carRecord) {
        if (carRecord == null || carRecord.car() == null || carRecord.year() == null) { return false;}
        if (carRecord.year() <= 1980 || carRecord.year() >= 2027) { return false;}

        return true;
    }



    //example    carRecord = <'Chevy',2004>
    public void add(CarRecord<String,Integer> carRecord) {
        //validation
        if(!carRecordIsValid(carRecord)) {
            return;
        }


        if (!this.cars.containsKey(carRecord)) {
            this.cars.put(carRecord, 1);
        } else {
            System.out.println("THIS CAR AND MODEL EXISTED ALREADY");
        }

    }

    public void remove(CarRecord<String,Integer> carRecord) {
        if(!carRecordIsValid(carRecord)) {
            return;
        }
    }

    public void printKeys() {
        Set<CarRecord<String,Integer>> carRecords = getCarRecords();
     //  carRecords =  {<"chevy",2004>,<"chevy",2003>}
        // for car in carRecords {}
        for(CarRecord<String,Integer> car: carRecords) {
            System.out.println(String.format("car: %s , year: %d", car.car(), car.year() ));
        }
    }

    public Set<CarRecord<String,Integer>> getCarRecords() {
        return this.cars.keySet();
    }
}
