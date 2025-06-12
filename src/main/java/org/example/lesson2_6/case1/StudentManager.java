package org.example.lesson2_6.case1;

import java.util.Iterator;
import java.util.List;

public class StudentManager {
    public static void removeStudentsWithLowAverage(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3) {
                iterator.remove();
            }
        }

    }

    public static void promoteStudents(List<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student s : students) {
            if (s.getCourse() == course) {
                s.getName();
            }
        }
    }
}