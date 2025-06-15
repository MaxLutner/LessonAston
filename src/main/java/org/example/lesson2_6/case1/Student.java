package org.example.lesson2_6.case1;

import java.util.ArrayList;
import java.util.Set;

public class Student {
    public String name;
    public String group;
    public int course;
    public ArrayList<Double> grades;

    public Student(String name, String group, int course, ArrayList<Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<Double>(grades);
    }

    public void getName() {
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}