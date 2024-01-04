package com.codesoft.task5;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getCapacity() > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println(name + " has successfully registered for " + course.getTitle());
        } else {
            System.out.println("Sorry, " + course.getTitle() + " is full. Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.capacity++;
            System.out.println(name + " has successfully dropped " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for " + course.getTitle() + ". Drop failed.");
        }
    }
}