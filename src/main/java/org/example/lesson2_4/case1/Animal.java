package org.example.lesson2_4.case1;

public abstract class Animal {
    public String name;
    static int countAnimals = 0;

    Animal(){
        countAnimals++;
    }
    static int getCountAnimals() {
        return countAnimals;
    }

    abstract void toRun(int range);
    abstract void toSwim(int range);
}