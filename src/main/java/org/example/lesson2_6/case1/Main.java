package org.example.lesson2_6.case1;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.lesson2_6.case1.StudentManager.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Иван", "А", 1, new ArrayList<>(Arrays.asList(4.0, 3.5, 4.2))));
        students.add(new Student("Мария", "Б", 2, new ArrayList<>(Arrays.asList(2.0, 2.5, 3.0))));
        students.add(new Student("Алексей", "А", 1, new ArrayList<>(Arrays.asList(3.0, 3.2, 3.5))));
        students.add(new Student("Ольга", "В", 3, new ArrayList<>(Arrays.asList(5.0, 4.8, 4.9))));

        System.out.println("Перед удалением и переводом:");
        students.forEach(System.out::println);

        printStudents(students, 1);

        printStudents(students, 2);

        printStudents(students, 3);

        removeStudentsWithLowAverage(students);

        promoteStudents(students);

        System.out.println("\nПосле удаления и перевода:");
        students.forEach(System.out::println);

        printStudents(students, 1);

        printStudents(students, 2);

        printStudents(students, 3);
    }
}
