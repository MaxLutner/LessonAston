package org.example.lesson2_7;

public class NumberComparator {
    private int a;
    private int b;

    public NumberComparator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String compare() {
        if (a > b) {
            return "Первое число больше второго";
        } else if (a < b) {
            return "Второе число больше первого";
        } else {
            return "Числа равны";
        }
    }
}
