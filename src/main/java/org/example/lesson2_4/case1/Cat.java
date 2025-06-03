package org.example.lesson2_4.case1;

public class Cat extends Animal {
    boolean isFull;
    static int countCats = 0;
    Cat(){
        super();
        countCats++;
        isFull=false;
    }
    boolean isHungry(){
        return isFull;
    }
    static int getCountCats() {
        return countCats;
    }

    void toRun(int range){
        if (range<=200){
        System.out.println(name + " пробежал " + range + "м");
        }
    }

    void toSwim(int range){
            System.out.println(name +" не умеет плавать");
    }

    void toSwim(){
        System.out.println(name +" не умеет плавать");
    }
    void toEat(int amountOfFood, Bowl bowl){
        if (amountOfFood<=bowl.amountOfFood){
            bowl.amountOfFood-=amountOfFood;
            isFull=true;
            System.out.println("Котик покутил");
        } else System.out.println("Котик не трогал миску. Может пора добавить туда еды?");
    }
}
