package Student_Management_System;

import java.util.*;

public class Student extends User {
    private final List<Course> registeredCourses = new ArrayList<>();
    private final Map<String, Integer> examResults = new HashMap<>();

    public Student(String name, String email, String password) {
        super(name, email, password);
    }

    /**
     * HOW TO CHOOSE AND ADD COURSE:
     * 1. System displays available courses with numbers (choice 1, 2, etc.)
     * 2. You enter the number (e.g., 1 for Java, 2 for Python)
     * 3. The system registers you for the selected course
     */
    public void registerCourse(List<Course> allCourses, Scanner sc) {
        System.out.println("📚 Available Courses:");
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + allCourses.get(i).getTitle());
        }
        System.out.print("Enter course number to register: ");
        try {
            int idx = Integer.parseInt(sc.nextLine());
            Course c = allCourses.get(idx - 1);
            registeredCourses.add(c);
            System.out.println("✅ Registered to " + c.getTitle());
        } catch (Exception e) {
            System.out.println("❌ Invalid input.");
        }
    }

    // ... [Rest of Student.java remains unchanged]

    public void addMaterialToOwnCourse(Scanner sc) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + registeredCourses.get(i).getTitle());
        }
        System.out.print("Choose course number to add material: ");
        try {
            int ch = Integer.parseInt(sc.nextLine());
            System.out.print("Enter material: ");
            String mat = sc.nextLine();
            registeredCourses.get(ch - 1).addMaterial(mat);
            System.out.println("✅ Material added.");
        } catch (Exception e) {
            System.out.println("❌ Error adding material.");
        }
    }

    public void accessMaterial(Scanner sc) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + registeredCourses.get(i).getTitle());
        }
        System.out.print("Choose course to view materials: ");
        try {
            int ch = Integer.parseInt(sc.nextLine());
            registeredCourses.get(ch - 1).displayMaterials();
        } catch (Exception e) {
            System.out.println("❌ Error viewing materials.");
        }
    }

    public void giveExam(Scanner sc) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + registeredCourses.get(i).getTitle());
        }
        System.out.print("Choose course to give exam: ");
        try {
            int ch = Integer.parseInt(sc.nextLine());
            Course course = registeredCourses.get(ch - 1);
            int score = course.getExam().conductExam(sc);
            examResults.put(course.getTitle(), score);
            System.out.println("✅ Exam completed. Score: " + score);
        } catch (Exception e) {
            System.out.println("❌ Error during exam.");
        }
    }

    public void viewResults() {
        if (examResults.isEmpty()) {
            System.out.println("📄 No results available.");
            return;
        }
        for (String course : examResults.keySet()) {
            System.out.println("Course: " + course + " | Score: " + examResults.get(course));
        }
    }
}