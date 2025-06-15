package org.example.lesson2_7;

public class ArithmeticOperations {
    private int num1;
    private int num2;

    public ArithmeticOperations(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }

    public int subtract() {
        return num1 - num2;
    }

    public int multiply() {
        return num1 * num2;
    }

    public double divide() {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) num1 / num2;
    }
}