package org.example.model;

public class Grade {
    private String studentId;
    private String studentName;
    private String courseID;
    private double gradeAssessment1;
    private double gradeAssessment2;
    private double gradeFinal;
    private double gradeAverage;
    private String gradeNote;

    // Constructor
    public Grade(String studentId, String studentName, String courseID, double gradeAssessment1,
                 double gradeAssessment2, double gradeFinal, double gradeAverage, String gradeNote) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseID = courseID;
        this.gradeAssessment1 = gradeAssessment1;
        this.gradeAssessment2 = gradeAssessment2;
        this.gradeFinal = gradeFinal;
        this.gradeAverage = gradeAverage;
        this.gradeNote = gradeNote;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getCourseID() { return courseID; }
    public double getGradeAssessment1() { return gradeAssessment1; }
    public double getGradeAssessment2() { return gradeAssessment2; }
    public double getGradeFinal() { return gradeFinal; }
    public double getGradeAverage() { return gradeAverage; }
    public String getGradeNote() { return gradeNote; }
}