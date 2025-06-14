package org.example.lesson_7.Tests;

import org.example.lesson_7.TriangleArea;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleAreaTestNG {
    @Test
    public void testArea() {
        assertEquals(TriangleArea.area(6,4),12.0);
        assertEquals(TriangleArea.area(0,10),0.0);
        assertEquals(TriangleArea.area(10,5),25.0);
    }
}
