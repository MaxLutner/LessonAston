package org.example.lesson2_7.Tests;
import org.example.lesson2_7.ArithmeticOperations;
import org.example.lesson2_7.FactorialCalculator;
import org.example.lesson2_7.NumberComparator;
import org.example.lesson2_7.TriangleAreaCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTests {

    // Тесты для FactorialCalculator
    @Test
    public void testFactorial() {
        FactorialCalculator fc = new FactorialCalculator();

        assertEquals(1, fc.factorial(0));
        assertEquals(1, fc.factorial(1));
        assertEquals(120, fc.factorial(5));

        // Проверка исключения для отрицательного числа
        assertThrows(IllegalArgumentException.class, () -> fc.factorial(-3));
    }

    // Тесты для TriangleAreaCalculator
    @Test
    public void testCalculateArea() {
        TriangleAreaCalculator tac = new TriangleAreaCalculator();

        // Треугольник со сторонами 3,4,5
        double area = tac.calculateArea(3,4,5);
        assertEquals(6.0, area, 0.0001);

        // Проверка исключения при несуществующем треугольнике
        assertThrows(IllegalArgumentException.class, () -> tac.calculateArea(1,2,10));

        // Проверка исключения при отрицательных сторонах
        assertThrows(IllegalArgumentException.class, () -> tac.calculateArea(-3,4,5));
    }

    // Тесты для ArithmeticOperations
    @Test
    public void testArithmeticOperations() {
        ArithmeticOperations ao = new ArithmeticOperations(10, 5);

        assertEquals(15, ao.add());
        assertEquals(5, ao.subtract());
        assertEquals(50, ao.multiply());

        assertEquals(2.0, ao.divide(), 0.0001);

        // Деление на ноль должно выбрасывать исключение
        ArithmeticOperations aoZero = new ArithmeticOperations(10, 0);

        assertThrows(ArithmeticException.class, () -> aoZero.divide());
    }

    // Тесты для NumberComparator
    @Test
    public void testCompare() {
        NumberComparator nc1 = new NumberComparator(10, 5);

        assertEquals("Первое число больше второго", nc1.compare());

        NumberComparator nc2 = new NumberComparator(3, 8);

        assertEquals("Второе число больше первого", nc2.compare());

        NumberComparator nc3 = new NumberComparator(7,7);

        assertEquals("Числа равны", nc3.compare());
    }
}
