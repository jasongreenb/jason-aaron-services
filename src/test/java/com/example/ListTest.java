package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ListTest {
    @Test
    void testNotNull() {
        CustomList cList = new CustomList<String>();
        assertNotNull(cList.getData());
        assertEquals("hello my friend", cList.getFirstObject());
    }

}
