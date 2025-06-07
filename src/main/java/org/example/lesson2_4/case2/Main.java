package org.example.lesson2_4.case2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5,"Red", "Blue");
        circle.printCharacteristics();

        Triangle triangle = new Triangle(3,4,5, "White", "Black");
        triangle.printCharacteristics();

        Rectangle rectangle = new Rectangle(5,7, "Purple", "Brown");
        rectangle.printCharacteristics();
    }
}
