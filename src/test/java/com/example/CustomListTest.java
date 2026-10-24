package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    private CustomList<String> customList;



    @BeforeEach
    void init() {
        // Runs before EACH individual test case
        // Ideal for resetting objects or mocks to ensure test isolation
        customList = new CustomList<>();


    }

    @Test
    @DisplayName("Test initialize customList object")
    void testInitCustomList() {
        assertNotNull(customList.data);
        assertEquals(0, customList.size());
    }

    @Test
    @DisplayName("Get an element by index")
    void testGet() {
        customList.add("HiJason");
        assertEquals("HiJason", customList.get(0));

    }

    @Test
    @DisplayName("Add an element test")
    void testAdd() {
        String variableToAdd = "HiJason";
        customList.add(variableToAdd);

        assertEquals(1, customList.size());
        assertNull(customList.get(2));

    }



}
