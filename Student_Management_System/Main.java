
package Student_Management_System;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Admin admin = new Admin("Admin", "admin@example.com", "admin123");
    private static final List<Student> allStudents = new ArrayList<>();
    private static final List<Course> allCourses = new ArrayList<>();

    public static void main(String[] args) {
        preloadData();

        while (true) {
            System.out.println("\n🎓 Welcome to Student Management System");
            System.out.println("choice 1. Register");
            System.out.println("choice 2. View Student");
            System.out.println("choice 3. Course");
            System.out.println("choice 4. Exam");
            System.out.println("choice 5. Result");
            System.out.println("choice 6. Exit");
            System.out.print("👉 Enter your choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> registerStudent();
                case 2 -> showStudents();
                case 3 -> studentCourseMenu();
                case 4 -> takeExam();
                case 5 -> viewResults();
                case 6 -> {
                    System.out.println("👋 Exiting... Bye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    private static void preloadData() {
        Course java = admin.createCourse("Java", "Java basics", 30);
        Course python = admin.createCourse("Python", "Python programming", 25);
        allCourses.add(java);
        allCourses.add(python);

        // Java Questions
        java.getExam().addQuestion("What is JVM?", List.of("Java Virtual Machine", "Java Manager", "Java Mapper"), 1);
        java.getExam().addQuestion("Which keyword is used to inherit a class?", List.of("super", "extends", "implements"), 2);
        java.getExam().addQuestion("Which is not a Java feature?", List.of("Object-oriented", "Platform Independent", "Pointer usage"), 3);
        java.getExam().addQuestion("Default size of int in Java?", List.of("2 bytes", "4 bytes", "8 bytes"), 2);
        java.getExam().addQuestion("Method that starts execution in Java?", List.of("start()", "init()", "main()"), 3);
        java.getExam().addQuestion("Which is used for exception handling?", List.of("catch", "handle", "try"), 3);
        java.getExam().addQuestion("Which package contains Scanner class?", List.of("java.util", "java.io", "java.lang"), 1);
        java.getExam().addQuestion("Java was developed by?", List.of("Microsoft", "Sun Microsystems", "IBM"), 2);

        // Python Questions
        python.getExam().addQuestion("Symbol for comment in Python?", List.of("#", "//", "/* */"), 1);
        python.getExam().addQuestion("Which keyword defines a function?", List.of("func", "def", "function"), 2);
        python.getExam().addQuestion("Which is not a Python datatype?", List.of("list", "tuple", "tree"), 3);
        python.getExam().addQuestion("How to print in Python?", List.of("print()", "echo()", "printf()"), 1);
        python.getExam().addQuestion("Correct file extension for Python?", List.of(".py", ".pt", ".python"), 1);
        python.getExam().addQuestion("What does len() do?", List.of("Returns length", "Returns index", "Returns type"), 1);
        python.getExam().addQuestion("Python is:", List.of("Compiled", "Interpreted", "Both"), 2);
        python.getExam().addQuestion("Which loop exists in Python?", List.of("repeat", "loop", "while"), 3);
    }


    private static void registerStudent() {
        System.out.print("👤 Enter Name: ");
        String name = sc.nextLine();
        System.out.print("📧 Enter Email: ");
        String email = sc.nextLine();
        System.out.print("🔐 Set Password: ");
        String pass = sc.nextLine();

        Student student = new Student(name, email, pass);
        allStudents.add(student);
        System.out.println("✅ Registration successful!");
    }

    private static void showStudents() {
        for (Student s : allStudents) {
            System.out.println("- " + s.getName() + " (" + s.getEmail() + ")");
        }
    }

    private static Student loginStudent() {
        System.out.print("📧 Email: ");
        String email = sc.nextLine();
        System.out.print("🔐 Password: ");
        String pass = sc.nextLine();
        for (Student s : allStudents) {
            if (s.getEmail().equalsIgnoreCase(email) && s.checkPassword(pass)) {
                return s;
            }
        }
        System.out.println("❌ Invalid credentials.");
        return null;
    }

    private static void studentCourseMenu() {
        Student student = loginStudent();
        if (student == null) return;
        while (true) {
            System.out.println("\n📚 Course Menu:");
            System.out.println("choice 1. Register Course");
            System.out.println("choice 2. Add Material");
            System.out.println("choice 3. View Material");
            System.out.println("choice 4. Back");
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> student.registerCourse(allCourses, sc);
                case 2 -> student.addMaterialToOwnCourse(sc);
                case 3 -> student.accessMaterial(sc);
                case 4 -> { return; }
                default -> System.out.println("❌ Invalid.");
            }
        }
    }

    private static void takeExam() {
        Student student = loginStudent();
        if (student != null) student.giveExam(sc);
    }

    private static void viewResults() {
        Student student = loginStudent();
        if (student != null) student.viewResults();
    }
}
