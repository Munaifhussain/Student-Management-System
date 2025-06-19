package Student_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String description;
    private int duration;
    private List<String> materials;
    private Exam exam;

    public Course(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.materials = new ArrayList<>();
        this.exam = new Exam();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public Exam getExam() {
        return exam;
    }

    public void addMaterial(String material) {
        materials.add(material);
    }

    public void displayMaterials() {
        if (materials.isEmpty()) {
            System.out.println("❌ No materials found.");
            return;
        }
        System.out.println("📘 Materials:");
        for (int i = 0; i < materials.size(); i++) {
            System.out.println("choice " + (i + 1) + ". " + materials.get(i));
        }
    }
}