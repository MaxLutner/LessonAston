package org.example.lesson2_2;


import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        int a=10, b=15;
        System.out.println(withinTenToTwenty(a,b));
        isNumberPositive(a);
        System.out.println(isNumberPositiveBool(a));
        String hello = "Hello...";
        repeater(hello, a);
        int year = 2000;
        System.out.println(isYearLeap(year));
        exchangeOneToZero();
        arrayFill();
        arrayWork();
        arrayDiagonal();
        int len = 12, initialValue=52;
        System.out.println(Arrays.toString(getArray(len, initialValue)));

    }
    //1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
    public static void printThreeWords(){
        System.out.println("Orange \nBanana \nApple");
    }
    //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    public static void checkSumSign(){
        int a=3, b=4;
        if (a+b>=0)
        {
            System.out.println("Сумма положительна");
        } else System.out.println("Сумма отрицательна");

    }
    //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
    public static void printColor(){
        int value = 150;
        if (value<=0){
            System.out.println("Красный");
        } else if(value>0&&value<=100){
            System.out.println("Жёлтый");
        } else System.out.println("Зелёный");
    }
    //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers(){
        int a=3, b=4;
        if (a >= b)
        {
            System.out.println("a>=b");
        } else System.out.println("a<b");
    }
    //5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean withinTenToTwenty(int a, int b){
        return a+b>=10&&a+b<=20;
    }
    //6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void isNumberPositive(int a){
        if(a>=0){
            System.out.println("a - положительное");
        } else System.out.println("a - отрицательное");
    }
    //7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    //Замечание: ноль считаем положительным числом.
    public static boolean isNumberPositiveBool(int a){
        return a>=0;
    }
    //8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
    public static void repeater(String w, int a){
        for (int i=0; i<a; i++)
            System.out.println(w);
    }
    //9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isYearLeap(int a){
        return a%400==0 || a%4==0 && a%100!=0;
    }
    //10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void exchangeOneToZero(){
        int nums[] = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i=0; i< nums.length; i++)
            if(nums[i]>0)
                nums[i]=0;
            else nums[i]=1;  ;
        System.out.println(Arrays.toString(nums));
    }
    //11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    public static void arrayFill(){
        int nums[] = new int[100];
        for (int i=0; i< nums.length; i++)
            nums[i]=i+1;

        System.out.println(Arrays.toString(nums));
    }
    //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void arrayWork(){
        int nums[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0; i< nums.length; i++)
            if (nums[i]<6)
                nums[i]=nums[i]*2;

        System.out.println(Arrays.toString(nums));
    }
    //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    public static void arrayDiagonal(){
        int[][] nums = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        for (int i=0; i<nums.length; i++)
        {
            for (int j=0; j<nums.length; j++)
            {
                if (i==j||i+j==nums.length-1) nums[i][j]=1;
            }
        }

        for (int i=0; i<nums.length; i++)
        {
            for (int j=0; j<nums.length; j++)
            {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();

        }
    }
    //14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    public static int[] getArray(int len, int initialValue){
        int nums[] = new int[len];
        for (int i=0; i<len; i++)
            nums[i]=initialValue;

        return nums;
    }
}