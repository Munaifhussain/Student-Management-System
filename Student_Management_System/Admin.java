package Student_Management_System;

import java.util.List;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    public Course createCourse(String title, String desc, int duration) {
        return new Course(title, desc, duration);
    }

    public void addMaterial(Course course, String material) {
        course.addMaterial(material);
    }

    public void deleteCourse(List<Course> courses, Scanner sc) {
        if (courses.isEmpty()) {
            System.out.println("❌ No courses to delete.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + courses.get(i).getTitle());
        }
        System.out.print("👉 Enter course number to delete: ");
        int idx;
        try {
            idx = Integer.parseInt(sc.nextLine());
            if (idx < 1 || idx > courses.size()) {
                System.out.println("❌ Invalid index.");
                return;
            }
            courses.remove(idx - 1);
            System.out.println("✅ Course deleted.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input.");
        }
    }
}