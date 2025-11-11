package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private int courseCapacity;
    private String subjectID;
    private String semesterID;
    private String professorID;

    // Constructor để tải dữ liệu (dùng trong JTable/ComboBox)
    public Course(String courseID, String courseName, int courseCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
    }

    // Constructor để TẠO MỚI (dùng trong form Thêm mới)
    public Course(String courseID, String courseName, int courseCapacity, String subjectID, String semesterID, String professorID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
        this.subjectID = subjectID;
        this.semesterID = semesterID;
        this.professorID = professorID;
    }

    // Getters
    public String getCourseID() { return courseID; }
    public String getCourseName() { return courseName; }
    public int getcourseCapacity() { return courseCapacity; }
    public String getsubjectID() { return subjectID; }
    public String getSemesterID() { return semesterID; }
    public String getProfessorID() { return professorID; }

    @Override
    public String toString() {
        // Đây là thứ sẽ hiển thị trong ComboBox (Giao diện Giảng viên)
        return courseName + " (" + courseName + ")";
    }
}