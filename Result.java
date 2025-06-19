package Student_Management_System;

public class Result {
    private final String courseTitle;
    private final int score;

    public Result(String courseTitle, int score) {
        this.courseTitle = courseTitle;
        this.score = score;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Course: " + courseTitle + " | Score: " + score;
    }
}