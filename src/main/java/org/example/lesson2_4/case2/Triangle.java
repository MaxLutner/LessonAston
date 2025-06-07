package org.example.lesson2_4.case2;

 public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    Triangle(int a, int b, int c, String fill, String border){
        if (a<b+c&&b<a+c&&c<a+b){
            this.a=a;
            this.b=b;
            this.c=c;
            this.fill=fill;
            this.border=border;
        } else System.out.println("Треугольника с такими сторонами не существует");
    }

     @Override
     public double perimeter() {
         return (double)this.a+this.b+this.c;
     }

     @Override
     public double area() {
         return Math.sqrt(((double)this.a+this.b+this.c) / 2 * (((double)this.a+this.b+this.c) / 2 - a) * (((double)this.a+this.b+this.c) / 2 - b) * (((double)this.a+this.b+this.c) / 2 - c));
     }

     @Override
     public String fill() {
         return "";
     }

     @Override
     public String border() {
         return "";
     }
 }