package org.example.model;

public class Grade {

    private String StudentID;
    private String CourseID;
    private Double GradeAssessment1;
    private Double GradeAssessment2;
    private Double GradeFinal;
    private Double GradeAverage;
    private String GradeNote;

    /**
     * Hàm khởi tạo rỗng
     */
    public Grade() { }

    // ----- Getters and Setters (BẮT BUỘC CÓ) -----

    public String getStudentID() { return StudentID; }
    public void setStudentID(String studentID) { this.StudentID = studentID; }

    public String getCourseID() { return CourseID; }
    public void setCourseID(String courseID) { this.CourseID = courseID; }

    public Double getGradeAssessment1() { return GradeAssessment1; }
    public void setGradeAssessment1(Double gradeAssessment1) { this.GradeAssessment1 = gradeAssessment1; }

    public Double getGradeAssessment2() { return GradeAssessment2; }
    public void setGradeAssessment2(Double gradeAssessment2) { this.GradeAssessment2 = gradeAssessment2; }

    public Double getGradeFinal() { return GradeFinal; }
    public void setGradeFinal(Double gradeFinal) { this.GradeFinal = gradeFinal; }

    public Double getGradeAverage() { return GradeAverage; }
    public void setGradeAverage(Double gradeAverage) { this.GradeAverage = gradeAverage; }

    public String getGradeNote() { return GradeNote; }
    public void setGradeNote(String gradeNote) { this.GradeNote = gradeNote; }
}