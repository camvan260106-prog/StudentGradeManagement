package org.example.model;

import java.util.Date;

public class Student {

    // Khai báo 11 biến
    private String studentId;
    private String StudentName;
    private Date StudentDOB;
    private String StudentGender;
    private String StudentMajor;
    private String StudentEmail;
    private String StudentPhone;
    private String StudentHometown;
    private String ParentName;
    private String ParentPhone;
    private String StudentStatus;

    /**
     * Hàm khởi tạo rỗng (Default Constructor)
     * BẮT BUỘC CÓ để DAO hoạt động.
     */
    public Student() { }

    // ----- Getters and Setters -----

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return StudentName; }
    public void setStudentName(String studentName) { this.StudentName = studentName; }

    public Date getStudentDOB() { return StudentDOB; }
    public void setStudentDOB(Date studentDOB) { this.StudentDOB = studentDOB; }

    public String getStudentGender() { return StudentGender; }
    public void setStudentGender(String studentGender) { this.StudentGender = studentGender; }

    public String getStudentMajor() { return StudentMajor; }
    public void setStudentMajor(String studentMajor) { this.StudentMajor = studentMajor; }

    public String getStudentEmail() { return StudentEmail; }
    public void setStudentEmail(String studentEmail) { this.StudentEmail = studentEmail; }

    public String getStudentPhone() { return StudentPhone; }
    public void setStudentPhone(String studentPhone) { this.StudentPhone = studentPhone; }

    public String getStudentHometown() { return StudentHometown; }
    public void setStudentHometown(String studentHometown) { this.StudentHometown = studentHometown; }

    public String getParentName() { return ParentName; }
    public void setParentName(String parentName) { this.ParentName = parentName; }

    public String getParentPhone() { return ParentPhone; }
    public void setParentPhone(String parentPhone) { this.ParentPhone = parentPhone; }

    public String getStudentStatus() { return StudentStatus; }
    public void setStudentStatus(String studentStatus) { this.StudentStatus = studentStatus; }
}