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
    @DisplayName("Initialize customList object")
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
    @DisplayName("Add an element")
    void testAdd() {
        String variableToAdd = "HiJason";
        customList.add(variableToAdd);

        assertEquals(1, customList.size());
        assertNull(customList.get(2));

    }

    @Test
    @DisplayName("Set an element by index")
    void testSet() {
        customList.add("HiJason");
        customList.set(0, "HiAaron");
        assertEquals("HiAaron", customList.get(0));
    }

    @Test
    @DisplayName("Find an element by index")
    void testFind() {
        customList.add("HiJason");
        customList.add("HiAaron");
        assertEquals(1, customList.find("HiAaron"));
        assertEquals(-1,customList.find("HiBob"));
    }

    @Test
    @DisplayName("Remove an element by value")
    void testRemove() {
        customList.add("HiJason");
        customList.add("HiAaron");
        assertEquals(2, customList.size());
        assertEquals(2, customList.currentCapacity);
        customList.remove("HiAaron");
        assertEquals(-1, customList.find("HiAaron"));
        assertEquals(1, customList.size);
        assertEquals(2, customList.currentCapacity);

    }
    @Test
    @DisplayName("Check if array is empty")
    void testIsEmpty() {
        assertEquals(0, customList.size());
        customList.add("HiAaron");
        assertEquals(1, customList.size());

    }
    @Test
    @DisplayName("Testing resize")
    void testResize() {
        customList.add("HiJason");
        customList.add("HiAaron");
        assertEquals(2, customList.currentCapacity);
        customList.add("HiAba");
        customList.add("HiIma");
        assertEquals(4, customList.currentCapacity);
    }

    @Test
    @DisplayName("Testing GET Function OUT OF BOUNDS")
    void testGetBounds() {
        assertNull(customList.get(-2));
        assertNull(customList.get(3));
        customList.add("HiJason");
        assertNull(customList.get(1));

    }
}
