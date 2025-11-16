package org.example.model;

public class Course {
    private String CourseId;
    private String CourseName;
    private int courseCapacity;
    private String SubjectID;
    private String SemesterID;
    private String ProfessorID;

    // ----- Constructors -----
    public Course() { }

    // ----- Getters and Setters -----

    public String getCourseId() { return CourseId; }
    public void setCourseId(String courseId) { this.CourseId = courseId; }

    public String getCourseName() { return CourseName; }
    public void setCourseName(String courseName) { this.CourseName = courseName; }

    public int getCourseCapacity() { return courseCapacity; }
    public void setCourseCapacity(int courseCapacity) { this.courseCapacity = courseCapacity; }

    public String getSubjectID() { return SubjectID; }
    public void setSubjectID(String subjectID) { this.SubjectID = subjectID; }

    public String getSemesterID() { return SemesterID; }
    public void setSemesterID(String semesterID) { this.SemesterID = semesterID; }

    public String getProfessorID() { return ProfessorID; }
    public void setProfessorID(String professorID) { this.ProfessorID = professorID; }
}