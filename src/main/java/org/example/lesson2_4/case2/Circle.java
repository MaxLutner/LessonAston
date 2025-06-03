package org.example.lesson2_4.case2;

public class Circle extends Figure {
    private double rad;
    public Circle(double rad, String fill, String border){
        this.rad=rad;
        this.border=border;
        this.fill=fill;
    }
    @Override
    public double area() {
        return Math.PI * rad * rad;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * rad;
    }

    @Override
    public String fill() {
        return fill;
    }

    @Override
    public String border() {
        return border;
    }
}
