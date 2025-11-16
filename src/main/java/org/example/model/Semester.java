package org.example.model;

import java.util.Date; // Dùng java.util.Date cho StartDate, EndDate

public class Semester {

    // Khai báo biến
    private String SemesterID;
    private String SemesterName;
    private Date StartDate;
    private Date EndDate;

    /**
     * Hàm khởi tạo rỗng (Default Constructor)
     * BẮT BUỘC CÓ để DAO hoạt động.
     */
    public Semester() { }

    // ----- Getters and Setters -----
    // để DAO gán dữ liệu vào

    public String getSemesterID() { return SemesterID; }
    public void setSemesterID(String semesterID) { this.SemesterID = semesterID; }

    public String getSemesterName() { return SemesterName; }
    public void setSemesterName(String semesterName) { this.SemesterName = semesterName; }

    public Date getStartDate() { return StartDate; }
    public void setStartDate(Date startDate) { this.StartDate = startDate; }

    public Date getEndDate() { return EndDate; }
    public void setEndDate(Date endDate) { this.EndDate = endDate; }

    @Override
    public String toString() {
        return SemesterName; // JComboBox sẽ tự động gọi hàm này
    }
}
