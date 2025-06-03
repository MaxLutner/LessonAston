package org.example.lesson2_4.case2;

public abstract class Figure implements Calculation {
    String fill;
    String border;

    public abstract String fill();
    public abstract String border();

    void printCharacteristics() {
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет заливки: " + fill);
        System.out.println("Цвет границы: " + border);
        System.out.println("------------------------------");
    }
}
