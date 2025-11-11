package org.example.model;

import java.util.Date; // Sử dụng java.util.Date

public class Student {

    private String studentId;
    private String studentName;
    private Date studentDOB;
    private String studentGender;
    private String studentMajor;
    private String studentEmail;
    private String studentPhone;
    private String studentHometown;
    private String parentName;
    private String parentPhone;
    private String studentStatus;

    // Constructor ()
    public Student(String studentId, String studentName, Date studentDOB, String studentGender,
                   String studentMajor, String studentEmail, String studentPhone, String studentHometown,
                   String parentName, String parentPhone, String studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDOB = studentDOB;
        this.studentGender = studentGender;
        this.studentMajor = studentMajor;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentHometown = studentHometown;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.studentStatus = studentStatus;
    }

    // Getters ()
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() { // Đổi từ getFullName -> getStudentName
        return studentName;
    }
    public Date getStudentDOB() {
        return studentDOB;
    }
    public String getStudentGender() {
        return studentGender;
    }
    public String getStudentMajor() {
        return studentMajor;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public String getStudentPhone() { return studentPhone; }
    public String getStudentHometown() { return studentHometown; }
    public String getParentName() { return  parentName; }
    public String getParentPhone() {return parentPhone; }
    public String getStudentStatus() {
        return studentStatus;
    }
}