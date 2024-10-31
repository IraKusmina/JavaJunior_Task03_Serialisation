package ru.kolomiets.task1;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int age;
    transient double gpa;


    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student - " +
                "name: " + name +
                ", age: " + age +
                ", gpa: " + gpa;
    }
}
