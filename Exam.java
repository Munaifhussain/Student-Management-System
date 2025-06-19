package Student_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam {
    private final List<QuestionEntry> questions;

    public Exam() {
        questions = new ArrayList<>();
    }

    public void addQuestion(String question, List<String> options, int correctIndex) {
        questions.add(new QuestionEntry(question, options, correctIndex));
    }

    public int conductExam(Scanner sc) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            QuestionEntry q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.question);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println("choice " + (j + 1) + ". " + q.options.get(j));
            }
            System.out.print("Your answer (1-" + q.options.size() + "): ");
            try {
                int ans = Integer.parseInt(sc.nextLine());
                if (ans == q.correctOption) score++;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Skipped.");
            }
        }
        return score;
    }

    static class QuestionEntry {
        String question;
        List<String> options;
        int correctOption;

        public QuestionEntry(String question, List<String> options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }
}
