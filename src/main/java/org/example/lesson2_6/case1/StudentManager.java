package org.example.lesson2_6.case1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

public class StudentManager {
    private Set<Student> students;

    public StudentManager() {
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentsWithLowAverage() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }
    public void promoteStudents() {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }

    public Set<Student> getStudents() {
        return students;
    }
}