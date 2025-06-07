package org.example.lesson2_4.case2;

public interface Calculation{

    public double perimeter();
    public double area();

    default String fill(Figure figure) {
        return figure.fill;
    }

    default String border(Figure figure){
        return figure.border;
    }
}