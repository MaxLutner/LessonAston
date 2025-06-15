package org.example.lesson2_7;

public class TriangleAreaCalculator {
    public double calculateArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Длины сторон должны быть положительными");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}