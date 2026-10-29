package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomSetOfCarsTest {

    // Corrected the type declaration and variable name syntax
    private CustomSetOfCars customSet;

    @BeforeEach
    void init() {
        // Initialize your default instance before each test runs
        customSet = new CustomSetOfCars("DefaultTestSet");
    }



    @Test
    @DisplayName("Check if Car Record is Valid")
    void testCarRecordIsValid(){

        // 1. Test a valid car record (should return true)
        CustomSetOfCars.CarRecord<String, Integer> validRecord = new CustomSetOfCars.CarRecord<>("Honda", 2015);
        assertTrue(customSet.carRecordIsValid(validRecord), "A Car with a valid brand and year should be valid.");
        //2. Test a null record(false)
        assertFalse(customSet.carRecordIsValid(null), "A null record should be invalid.");
        //3. Test a null brand (false)
        CustomSetOfCars.CarRecord<String, Integer> nullBrand = new CustomSetOfCars.CarRecord<>(null, 2015);
        assertFalse(customSet.carRecordIsValid(nullBrand), "A record with a null brand should be invalid");
        // 4. Test a record with a null year (should return false)
        CustomSetOfCars.CarRecord<String, Integer>nullYear = new CustomSetOfCars.CarRecord<>("Honda", null);
        assertFalse(customSet.carRecordIsValid(nullYear), "A Record with a null year should be invalid");
        // 5. Test a record with a year that is too old (<= 1980)
        CustomSetOfCars.CarRecord<String, Integer> tooOld = new CustomSetOfCars.CarRecord<>("Honda", 1800);
        assertFalse(customSet.carRecordIsValid(tooOld), "A record with a year that is older t han 1980 should be invalid");
        // 6. Test a record with a year that is too far in the future (>= 2027)
        CustomSetOfCars.CarRecord<String, Integer> futureCar = new CustomSetOfCars.CarRecord<>("Honda", 2300);



    }
    @Test
    @DisplayName("Add a car record")
    void testAdd(){
        //1 Test adding a valid car to the set
        CustomSetOfCars.CarRecord<String, Integer> validRecord = new CustomSetOfCars.CarRecord<>("Honda", 2015);
        customSet.add(validRecord);
        assertEquals(1, customSet.size(), "The Size of the Set should be 1 after adding 1 record");
        //2 Test adding a duplicate car to the set (same object twice)
        customSet.add(validRecord);
        customSet.add(validRecord);
        assertEquals(1, customSet.size(), "The size of this set should still be 1 even after adding the same car twice");
        //3
    }
}