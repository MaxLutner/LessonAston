package org.example.lesson_7.Tests;

import org.example.lesson_7.Factorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTestNG {
    @Test
    public void testFactorial() {
        assertEquals(Factorial.factorial(0), 1);
        assertEquals(Factorial.factorial(1), 1);
        assertEquals(Factorial.factorial(5), 120);
        assertEquals(Factorial.factorial(10), 3628800);
        Factorial.factorial(-3);
    }
}