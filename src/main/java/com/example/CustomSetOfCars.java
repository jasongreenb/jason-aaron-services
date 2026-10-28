package com.example;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class CustomSetOfCars  {

    public static void main(String[] args) {
//        CustomSetOfCars cars1 = new CustomSetOfCars();
//        cars1.add(new CarRecord<String,Integer>("Chevy",2004));
//        cars1.add(new CarRecord<String,Integer>("Chevy",2003));
//        cars1.add(new CarRecord<String,Integer>("Chevy",2004));
//     //   cars.printKeys();
//        cars1.add(null);
//        cars1.add(new CarRecord<>(null, 2018));
//        cars1.add(new CarRecord<>("Chevy", null));
//        cars1.remove(new CarRecord<>("Chevy",2004));
//        boolean carExists = cars1.containsCarRecord(new CarRecord<>("Chevy",2004));
//        carExists = cars1.containsCarRecord(new CarRecord<>("Chevy",2003));
//        cars1.printKeys();

        CustomSetOfCars cars2 = new CustomSetOfCars("cars2");
        cars2.add(new CarRecord<String,Integer>("Chevy",2001));
        cars2.add(new CarRecord<String,Integer>("Chevy",2002));
        cars2.add(new CarRecord<String,Integer>("Chevy",2003));

        CustomSetOfCars cars3 = new CustomSetOfCars("cars3");
        cars3.add(new CarRecord<String,Integer>("Chevy",2001));
        cars3.add(new CarRecord<String,Integer>("Chevy",2002));
        cars3.add(new CarRecord<String,Integer>("Chevy",2004));


        CustomSetOfCars cars2UnionCars3 = cars2.union(cars3);
        CustomSetOfCars cars2MinusCars3 = cars2.subtract(cars3);
        cars2UnionCars3.printKeys();
        cars2MinusCars3.printKeys();


    }
    // define what a car record is: CarRecord = <car,year>
    public record CarRecord<L,R>(L car, R year) {};

    // a map that holds CarRecord as the key with the value as 1 if that carRecord exists
    HashMap<CarRecord<String,Integer>, Integer> cars;
    String name;

    public HashMap<CarRecord<String, Integer>, Integer> getCars() {
        return this.cars;
    }


    // (1,2,3).subtract(1,2,4) = (3)
    public CustomSetOfCars subtract(CustomSetOfCars otherCarSet) {
        if(otherCarSet == null) {
            return null;
        }

        System.out.println("START OF SUBTRACT FUNCTION");
        CustomSetOfCars subtractSet = new CustomSetOfCars(String.format("Set: %s - set: %s", this.name, otherCarSet.name));

        for(CarRecord<String, Integer> carRecord: getCars().keySet()) {
            subtractSet.add(carRecord);
        }

        for(CarRecord<String, Integer> carRecord: otherCarSet.getCars().keySet()) {
            subtractSet.remove(carRecord);
        }
        System.out.println("END OF SUBTRACT FUNCTION");
        return subtractSet;







    }

    // (1,2,3).union(1,2,4) = (1,2,3,4)
    public CustomSetOfCars union(CustomSetOfCars otherCarSet){
        if(otherCarSet == null) {
            return null;
        }


        System.out.println("START OF UNION FUNCTION");
        CustomSetOfCars unionedSet = new CustomSetOfCars("unionSet");

        // this.cars  = {CarRecord<"Chevy",2001> : 1 ,CarRecord<"Chevy",2002> : 1, CarRecord<"Chevy",2003> : 1   }
        // this.cars.keySet() = (CarRecord<"Chevy",2001>,CarRecord<"Chevy",2002>,CarRecord<"Chevy",2003>)
        // for each CarRecord in this.cars.keySet()
        for (CarRecord<String,Integer> carRecord: this.cars.keySet()) {
            unionedSet.add(carRecord);
        }

        for (CarRecord<String,Integer> carRecord: otherCarSet.getCars().keySet()) {
            unionedSet.add(carRecord);
        }

        System.out.println("END OF UNION FUNCTION");

        return unionedSet;
    }


    public CustomSetOfCars(String name){
        this.cars = new HashMap<>();
        this.name = name;

    }

    public int size() {
        return this.cars.keySet().size();
    }

    public boolean containsCarRecord(CarRecord<String, Integer> carRecord) {
        if(!carRecordIsValid(carRecord)) {
            return false;
        }

        return this.cars.containsKey(carRecord);
    }


    public boolean carRecordIsValid(CarRecord<String,Integer> carRecord) {
        if (carRecord == null || carRecord.car() == null || carRecord.year() == null) {
            System.out.println("CAR RECORD PASSED WAS NOT VALID BECAUSE OF NULL VALUES");
            return false;
        }
        if (carRecord.year() <= 1980 || carRecord.year() >= 2027) {
            System.out.println("CAR RECORD PASSED WAS NOT VALID BECAUSE OF THE YEAR");

            return false;
        }

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
            System.out.println(String.format("THIS CAR AND MODEL EXISTED ALREADY brand: %s, year: %d inside of the customCarSet: %s", carRecord.car(), carRecord.year(), this.name));
        }

    }

    public void remove(CarRecord<String,Integer> carRecord) {
        if(!carRecordIsValid(carRecord)) {
            return;
        }

        if(this.cars.containsKey(carRecord)) {
            this.cars.remove(carRecord);
            return;
        }


        System.out.println(String.format("Car record <%s,%d> doesnt exist in %s", carRecord.car(), carRecord.year(), this.name));


    }

    public void printKeys() {
        Set<CarRecord<String,Integer>> carRecords = getCarRecords();
     //  carRecords =  {<"chevy",2004>,<"chevy",2003>}
        // for car in carRecords {}
        System.out.println(String.format("THIS SET HOLDS %d cars", size()));
        for(CarRecord<String,Integer> car: carRecords) {
            System.out.println(String.format("car: %s , year: %d", car.car(), car.year() ));
        }
    }

    public Set<CarRecord<String,Integer>> getCarRecords() {
        return this.cars.keySet();
    }
}
