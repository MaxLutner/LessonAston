package org.example.lesson2_6.case1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.example.lesson2_6.case1.StudentManager.*;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student s1 = new Student("Иван", "Группа1", 1, new double[]{4.0, 3.5, 4.2});
        Student s2 = new Student("Мария", "Группа2", 2, new double[]{2.0, 2.5, 3.0});
        Student s3 = new Student("Петр", "Группа1", 1, new double[]{3.0, 3.2, 2.8});
        Student s4 = new Student("Алексей", "Группа3", 3, new double[]{4.5, 4.0, 4.8});
        Student s5 = new Student("Елена", "Группа2", 2, new double[]{3.0, 3.5, 3.8});
        Student s6 = new Student("Дмитрий", "Группа1", 1, new double[]{2.0, 2.5, 2.8});
        Student s7 = new Student("Ольга", "Группа3", 3, new double[]{4.0, 4.2, 4.5});
        Student s8 = new Student("Сергей", "Группа2", 2, new double[]{3.0, 2.8, 3.2});
        Student s9 = new Student("Наталья", "Группа1", 1, new double[]{3.5, 3.7, 3.9});
        Student s10 = new Student("Михаил", "Группа4", 4, new double[]{4.8, 4.9, 5.0});

        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);
        manager.addStudent(s4);
        manager.addStudent(s5);
        manager.addStudent(s6);
        manager.addStudent(s7);
        manager.addStudent(s8);
        manager.addStudent(s9);
        manager.addStudent(s10);

        manager.removeStudentsWithLowAverage();

        manager.promoteStudents();

        manager.printStudents(manager.getStudents(), 1);
        manager.printStudents(manager.getStudents(), 2);
        manager.printStudents(manager.getStudents(), 3);
        manager.printStudents(manager.getStudents(), 4);

        System.out.println("\nВсе студенты:");
        for (Student s : manager.getStudents()) {
            System.out.println(s.getName() + " - курс: " + s.getCourse());
        }
    }
}
