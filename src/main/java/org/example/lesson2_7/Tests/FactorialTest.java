package org.example.lesson2_7.Tests;

import org.example.lesson2_7.Factorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(120, Factorial.factorial(5));
        assertEquals(3628800, Factorial.factorial(10));
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-3));
    }
}

