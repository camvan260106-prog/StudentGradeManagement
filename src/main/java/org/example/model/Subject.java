package org.example.model;

public class Subject {
    private String subjectID;
    private String subjectName;
    private int subjectCredit;
    private String semesterID;
    private String professorID;

    // Constructor để tải dữ liệu (dùng trong JTable/ComboBox)
    public Subject(String subjectID, String subjectName, int subjectCredit) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectCredit = subjectCredit;
    }

    // Constructor để TẠO MỚI (dùng trong form Thêm mới)//thêm môn học ở giao diện admin
    public Subject(String subjectID, String subjectName, int subjectCredit, String semesterID, String professorID) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectCredit = subjectCredit;
        this.semesterID = semesterID;
        this.professorID = professorID;
    }

    // Getters
    public String getSubjectID() { return subjectID; }
    public String getSubjectName() { return subjectName; }
    public int getSubjectCredit() { return subjectCredit; }
    public String getSemesterID() { return semesterID; }
    public String getProfessorID() { return professorID; }

    @Override
    public String toString() {
        // Đây là thứ sẽ hiển thị trong ComboBox (Giao diện Giảng viên)
        return subjectName + " (" + subjectName + ")";
    }
}