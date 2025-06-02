package org.example.lesson2_3.case2;

public class Main {
    public static void main(String[] args) {
        Park park = new Park();

        Park.Attraction karusel = park.new Attraction();
        karusel.setCost("123");
        karusel.setName("Карусель");
        karusel.setWorkTime("10:00-23:00");

        karusel.displayInfo();

    }
}
