package org.example.model;

import java.util.Date; // <-- Thêm import

public class Semester {
    private String semesterID;
    private String semesterName;
    private Date startDate;
    private Date endDate;

    // Constructor (dùng cho ComboBox)
    public Semester(String semesterID, String semesterName) {
        this.semesterID = semesterID;
        this.semesterName = semesterName;
    }

    // Constructor đầy đủ (dùng cho Bảng và Thêm/Sửa)
    public Semester(String semesterID, String semesterName, Date startDate, Date endDate) {
        this.semesterID = semesterID;
        this.semesterName = semesterName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public String getSemesterID() { return semesterID; }
    public String getSemesterName() { return semesterName; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }

    @Override
    public String toString() {
        // Đây là thứ sẽ hiển thị trong ComboBox
        return semesterName;
    }
}