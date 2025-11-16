// Đặt trong: org/example/model/StudentCourseView.java
package org.example.model;

public class StudentCourseView {

    private String courseName;
    private String semesterID;
    private String subjectID;
    private String subjectName;
    private int subjectCredit;
    private String professorName;

    public StudentCourseView() {}

    // ----- Getters and Setters -----

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getSemesterID() { return semesterID; }
    public void setSemesterID(String semesterID) { this.semesterID = semesterID; }

    public String getSubjectID() { return subjectID; }
    public void setSubjectID(String subjectID) { this.subjectID = subjectID; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getSubjectCredit() { return subjectCredit; }
    public void setSubjectCredit(int subjectCredit) { this.subjectCredit = subjectCredit; }

    public String getProfessorName() { return professorName; }
    public void setProfessorName(String professorName) { this.professorName = professorName; }
}