package org.example.lesson2_7.Tests;

import org.example.lesson2_7.Arithmetic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ArithmeticTestNG {
    @Test
    public void testAdd() {
        assertEquals(Arithmetic.add(2,3),5);
        assertEquals(Arithmetic.add(-2,1),-1);
    }

    @Test
    public void testSubtract() {
        assertEquals(Arithmetic.subtract(2,3), -1);
        assertEquals(Arithmetic.subtract(-2,-3),1);
    }

    @Test
    public void testMultiply() {
        assertEquals(Arithmetic.multiply(-2,-3),6);
        assertEquals(Arithmetic.multiply(-2,3),-6);
    }

    @Test
    public void testDivide() {
        assertEquals((double)6/3 , Arithmetic.divide(6 ,3));
        try {
            Arithmetic.divide(10 ,0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {}
    }
}
