package org.example.lesson2_7.Tests;

import org.example.lesson2_7.Comparator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComparatorTest {
    @Test
    void testCompareEqual() {
        assertEquals(0, Comparator.compare(5, 5));
    }

    @Test
    void testCompareLess() {
        assertTrue(Comparator.compare(3, 5) < 0);
    }

    @Test
    void testCompareGreater() {
        assertTrue(Comparator.compare(10, 5) > 0);
    }
}
