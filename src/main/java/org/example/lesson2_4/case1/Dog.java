package org.example.lesson2_4.case1;

public class Dog extends Animal {
    static int countDogs = 0;
    Dog(){
        super();
        countDogs++;
    }

    static int getCountDogs() {
        return countDogs;
    }

    void toRun(int range){
        if (range<=500){
            System.out.println(name + " пробежал " + range + "м");
        }
    }

    void toSwim(int range){
        if (range<=10) {
            System.out.println(name + " проплыл " + range + "м");
        }
    }
}
