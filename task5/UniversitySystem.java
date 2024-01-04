package com.codesoft.task5;

import java.util.List;
import java.util.Scanner;

public class UniversitySystem {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();

        Course c1 = new Course("CS101", "Introduction to Programming", "Fundamentals of programming", 30, "Mon/Wed 10:00 AM");
        Course c2 = new Course("ENG201", "English Literature", "Classic literature analysis", 25, "Tue/Thu 2:00 PM");
        Course c3 = new Course("MAT301", "Calculus", "Advanced calculus concepts", 20, "Mon/Fri 1:00 PM");

        courseManager.addCourse(c1);
        courseManager.addCourse(c2);
        courseManager.addCourse(c3);

        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");

        Scanner scanner = new Scanner(System.in);

        // Student 1 registration
        courseManager.displayCourses();
        System.out.println("Student 1: " + student1.getName() + ", ID: " + student1.getStudentID());
        System.out.print("Enter the course code to register for: ");
        String courseCode1 = scanner.nextLine();
        Course selectedCourse1 = findCourseByCode(courseManager, courseCode1);

        if (selectedCourse1 != null) {
            student1.registerCourse(selectedCourse1);
        } else {
            System.out.println("Invalid course code.");
        }

        // Student 2 registration
        courseManager.displayCourses();
        System.out.println("Student 2: " + student2.getName() + ", ID: " + student2.getStudentID());
        System.out.print("Enter the course code to register for: ");
        String courseCode2 = scanner.nextLine();
        Course selectedCourse2 = findCourseByCode(courseManager, courseCode2);

        if (selectedCourse2 != null) {
            student2.registerCourse(selectedCourse2);
        } else {
            System.out.println("Invalid course code.");
        }

        // Course removal for Student 1
        System.out.println("Courses registered by " + student1.getName() + ":");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.print("Enter the course code to drop: ");
        String dropCode1 = scanner.nextLine();
        Course dropCourse1 = findCourseByCode(student1.getRegisteredCourses(), dropCode1);

        if (dropCourse1 != null) {
            student1.dropCourse(dropCourse1);
        } else {
            System.out.println("Invalid course code or not registered for the course.");
        }

        // Course removal for Student 2
        System.out.println("Courses registered by " + student2.getName() + ":");
        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.print("Enter the course code to drop: ");
        String dropCode2 = scanner.nextLine();
        Course dropCourse2 = findCourseByCode(student2.getRegisteredCourses(), dropCode2);

        if (dropCourse2 != null) {
            student2.dropCourse(dropCourse2);
        } else {
            System.out.println("Invalid course code or not registered for the course.");
        }
    }

    private static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Course findCourseByCode(CourseManager courseManager, String courseCode) {
        return findCourseByCode(courseManager.getCourses(), courseCode);
    }
}