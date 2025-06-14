package org.example.lesson2_7.Tests;

import org.example.lesson2_7.Arithmetic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArithmeticTest {
    @Test
    void testAdd() {
        assertEquals(5, Arithmetic.add(2, 3));
        assertEquals(-1, Arithmetic.add(-2, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(-1, Arithmetic.subtract(2, 3));
        assertEquals(-3, Arithmetic.subtract(-2, 1));
    }

    @Test
    void testMultiply() {
        assertEquals(6, Arithmetic.multiply(2, 3));
        assertEquals(-2, Arithmetic.multiply(-2, 1));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, Arithmetic.divide(6, 3));
        assertThrows(ArithmeticException.class, () -> {
            Arithmetic.divide(10, 0);
        });
    }
}
