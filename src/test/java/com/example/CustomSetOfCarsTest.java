package com.example;

import org.junit.jupiter.api.*;
import com.example.Objects.CarRecord;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomSetOfCarsTest {

    // Corrected the type declaration and variable name syntax
    private CustomSetOfCars customSet;
    private Object customSetOfCars;

    @BeforeEach
    void init() {
        // Initialize your default instance before each test runs
        customSet = new CustomSetOfCars("DefaultTestSet");
    }



    @Test
    @DisplayName("Check if Car Record is Valid")
    @Order(1)
    void testCarRecordIsValid(){

        // 1. Test a valid car record (should return true)
        CarRecord<String, Integer> validRecord = new CarRecord<>("Honda", 2015);
        assertTrue(customSet.carRecordIsValid(validRecord), "A Car with a valid brand and year should be valid.");
        //2. Test a null record(false)
        assertFalse(customSet.carRecordIsValid(null), "A null record should be invalid.");
        //3. Test a null brand (false)
        CarRecord<String, Integer> nullBrand = new CarRecord<>(null, 2015);
        assertFalse(customSet.carRecordIsValid(nullBrand), "A record with a null brand should be invalid");
        // 4. Test a record with a null year (should return false)
        CarRecord<String, Integer> nullYear = new CarRecord<>("Honda", null);
        assertFalse(customSet.carRecordIsValid(nullYear), "A Record with a null year should be invalid");
        // 5. Test a record with a year that is too old (<= 1980)
        CarRecord<String, Integer> tooOld = new CarRecord<>("Honda", 1800);
        assertFalse(customSet.carRecordIsValid(tooOld), "A record with a year that is older than 1980 should be invalid");
        // 6. Test a record with a year that is too far in the future (>= 2027)
        CarRecord<String, Integer> futureCar = new CarRecord<>("Honda", 2300);

    }

    @Test
    @DisplayName("Add a car record")
    void testAdd(){

        //1 Test adding a valid car to the set
        CarRecord<String, Integer> validRecord = new CarRecord<>("Honda", 2015);
        customSet.add(validRecord);
        assertEquals(1, customSet.size(), "The Size of the Set should be 1 after adding 1 record");
        //2 Test adding a duplicate car to the set (same object twice)
        customSet.add(validRecord);
        customSet.add(validRecord);
        assertEquals(1, customSet.size(), "The size of this set should still be 1 even after adding the same car twice");
        //3 Test adding 2 car records with identical values but different objects
        customSet.add(validRecord);
        CarRecord<String, Integer> duplicateValidRecord = new CarRecord<>("Honda", 2015);
        customSet.add(duplicateValidRecord);
        assertEquals(1, customSet.size(), "The size of this set should still be 1 even after adding 2 objects with identical values");


    }
    @Test
    @DisplayName("Union between 2 sets")
    void testUnion(){
        //1 Testing both sets are empty
        CustomSetOfCars setA = new CustomSetOfCars("setA");
        CustomSetOfCars setB = new CustomSetOfCars("setB");
        CustomSetOfCars setUNIONED = setA.union(setB);
        assertEquals(0, setUNIONED.size());
        //2 testing one set is empty, other set has cars
        CarRecord<String, Integer> car = new CarRecord<>("Honda", 2015);
        setB.add(car);
        CustomSetOfCars setUNIONED2 = setA.union(setB);
        assertEquals (1, setUNIONED2.size());
        //3 testing the reverse, first set has cars, other set is empty
        CustomSetOfCars setC = new CustomSetOfCars("setC");
        CustomSetOfCars setD = new CustomSetOfCars("setD");
        CarRecord<String, Integer> car2 = new CarRecord<>("Honda", 2015);
        setD.add(car2);
        CustomSetOfCars setUNIONED3 = setC.union(setD);
        assertEquals(1, setUNIONED3.size());
        //4 where both sets have cars, but none of the cars overlap.
        CustomSetOfCars setE = new CustomSetOfCars ("setE");
        CustomSetOfCars setF = new CustomSetOfCars ("setF");
        CarRecord<String, Integer> car3 = new CarRecord<>("Honda", 2015);
        CarRecord<String, Integer> car4 = new CarRecord<>("Ford", 2015);
        CarRecord<String, Integer> car5 = new CarRecord<>("Mazda", 2015);
        CarRecord<String, Integer> car6 = new CarRecord<>("Mustang", 2015);
        setE.add(car3);
        setE.add(car4);
        setF.add(car5);
        setF.add(car6);
        CustomSetOfCars setUNIONED4 = setE.union(setF);
        assertEquals(4, setUNIONED4.size());
        //5 both sets have cars, but they share some of the exact same car records
        CustomSetOfCars setG = new CustomSetOfCars("setG");
        CustomSetOfCars setH = new CustomSetOfCars("setH");
        CarRecord<String, Integer> car7 = new CarRecord<>("Honda", 2016);
        CarRecord<String, Integer> car8 = new CarRecord<>("Ford", 2016);
        CarRecord<String, Integer> car9 = new CarRecord<>("Mazda", 2016);
        CarRecord<String, Integer> car10 = new CarRecord<>("Mustang", 2016);
        CarRecord<String, Integer> car11 = new CarRecord<>("Lambo", 2016);
        setG.add(car7);
        setG.add(car8);
        setG.add(car9);
        setH.add(car7);
        setH.add(car10);
        setH.add(car11);
        CustomSetOfCars setUNIONED5 = setG.union(setH);
        assertEquals(5, setUNIONED5.size());
        //6 passed one set that is null
        CustomSetOfCars setI = new CustomSetOfCars("setI");
        CustomSetOfCars setJ = null;
        CarRecord<String, Integer> car12 = new CarRecord<>("Honda", 2019);
        setI.add(car12);
        CustomSetOfCars setUNIONED6 = setI.union(setJ);
        assertNull(setUNIONED6);
    }

}
