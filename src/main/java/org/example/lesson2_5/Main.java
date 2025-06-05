package org.example.lesson2_5;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            ArrayInstrumental.checkSize4x4(correctArray);
            System.out.println("Массив правильного размера");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            ArrayInstrumental.checkSize4x4(wrongArray);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int totalSum = ArrayInstrumental.sumArrayElements(correctArray);
            System.out.println("Сумма элементов: " + totalSum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int totalSum = ArrayInstrumental.sumArrayElements(wrongDataArray);
            System.out.println("Сумма элементов: " + totalSum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int result = ArrayInstrumental.sumArrayElements(correctArray);
            System.out.println("Общая сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }

        try {
            String value = wrongArray[3][0];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обнаружено исключение: " + e);
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}