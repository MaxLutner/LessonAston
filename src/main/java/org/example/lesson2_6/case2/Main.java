package org.example.lesson2_6.case2;

public class Main {
    public static void main(String[] args) {
        Guide guide = new Guide();

        guide.add("Ivanov", "123456");
        guide.add("Petrov", "654321");
        guide.add("Ivanov", "789012");
        guide.add("Sidorov", "111222");

        System.out.println("Phones of Ivanov: " + guide.get("Ivanov"));
        System.out.println("Phones of Petrov: " + guide.get("Petrov"));
        System.out.println("Phones of Sidorov: " + guide.get("Sidorov"));
        System.out.println("Phones of non-existing surname: " + guide.get("Kuznetsov"));
    }
}
