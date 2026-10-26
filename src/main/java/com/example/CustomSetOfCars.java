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

    }


    public record CarRecord<L,R>(L car, R year) {};
    HashMap<CarRecord<String,Integer>, Integer> cars;

    public CustomSetOfCars(){
        this.cars = new HashMap<CarRecord<String,Integer>, Integer>();

    }
//example    carRecord = <'Chevy',2004>
    public void add(CarRecord<String,Integer> carRecord) {
        //validation
        if (carRecord == null || carRecord.car() == null) { return;}
        if (carRecord.year() <= 1980 || carRecord.year() >= 2027) { return;}


        if (!this.cars.containsKey(carRecord)) {
            this.cars.put(carRecord, 1);
        } else {
            System.out.println("THIS CAR AND MODEL EXISTED ALREADY");
        }

    }

    public void printKeys() {
        Set<CarRecord<String,Integer>> carRecords = getCarRecords();
     //  carRecords =  {<"chevy",2004>,<"chevy",2003>}
        // for car in carRecords {}
        for(CarRecord<String,Integer> car: carRecords) {
            System.out.println(String.format("car: %s , year: %d", car.car, car.year ));
        }
    }

    public Set<CarRecord<String,Integer>> getCarRecords() {
        return this.cars.keySet();
    }
}
