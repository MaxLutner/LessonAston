package org.example.lesson2_4.case1;

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        Animal c = new Cat();

        System.out.println("Общее количество животных: " + Animal.getCountAnimals());
        System.out.println("Количество собак: " + Dog.getCountDogs());
        System.out.println("Количество котов: " + Cat.getCountCats());

        Cat cats[]=new Cat[5];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
        }
        Bowl bowl = new Bowl();

        bowl.addFood(100);
        for (int i = 0; i < cats.length; i++) {
            bowl.checkFood();
            cats[i].isHungry();
            cats[i].toEat((int)(Math.random() * 20) + 10,bowl);
        }
    }
}
