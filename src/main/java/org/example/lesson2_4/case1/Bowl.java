package org.example.lesson2_4.case1;

public class Bowl {
    int amountOfFood;

    void addFood(int amountOfFood){
        this.amountOfFood+=amountOfFood;
    }

    void checkFood(){
        System.out.println("еды в миске:" + amountOfFood);
    }
}
