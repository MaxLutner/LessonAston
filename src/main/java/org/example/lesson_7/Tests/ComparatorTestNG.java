package org.example.lesson_7.Tests;

import org.example.lesson_7.Comparator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComparatorTestNG {
    @Test
    public void testCompareEqual() {
        equals(Comparator.compare(5 ,5));
    }

    @Test
    public void testCompareLess() {
        assertTrue(Comparator.compare (3 ,5) <0 );
    }

    @Test
    public void testCompareGreater() {
        assertTrue(Comparator.compare (10 ,5) >0 );
    }
}
