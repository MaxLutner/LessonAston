package org.example.lesson2_4.case2;

public class Rectangle extends Figure {
    private double width;
    private double height;
    public Rectangle(double width, double height, String fill, String border) {
        this.width = width;
        this.height = height;
        this.fill = fill;
        this.border = border;
    }
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
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
