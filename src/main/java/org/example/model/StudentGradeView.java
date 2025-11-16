package org.example.model;

/**
 * Lớp này không phải là bảng CSDL, đây là lớp "Data Transfer Object" (DTO)
 * dùng để chứa dữ liệu JOIN từ 3 bảng (Grade, Course, Subject)
 * và hiển thị lên JTable trong StudentForm.
 */
public class StudentGradeView {

    // Từ bảng Subject
    private String SubjectID;
    private String SubjectName;
    private int SubjectCredit;

    // Từ bảng Course
    private String CourseName;

    // Từ bảng Grade
    private Double GradeAssessment1;
    private Double GradeAssessment2;
    private Double GradeFinal;
    private Double GradeAverage;
    private String GradeNote;

    /**
     * Hàm khởi tạo rỗng (Default Constructor)
     * BẮT BUỘC CÓ để các DAO hoạt động
     */
    public StudentGradeView() { }

    // ----- Getters and Setters (BẮT BUỘC CÓ) -----

    public String getSubjectID() { return SubjectID; }
    public void setSubjectID(String subjectID) { this.SubjectID = subjectID; }

    public String getSubjectName() { return SubjectName; }
    public void setSubjectName(String subjectName) { this.SubjectName = subjectName; }

    public int getSubjectCredit() { return SubjectCredit; }
    public void setSubjectCredit(int subjectCredit) { this.SubjectCredit = subjectCredit; }

    public String getCourseName() { return CourseName; }
    public void setCourseName(String courseName) { this.CourseName = courseName; }

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