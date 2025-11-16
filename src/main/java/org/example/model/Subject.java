package org.example.model;

public class Subject {

    private String SubjectID;
    private String SubjectName;
    private int SubjectCredit;

    /**
     * Hàm khởi tạo rỗng (BẮT BUỘC CÓ)
     */
    public Subject() { }

    // ----- Getters and Setters

    public String getSubjectID() { return SubjectID; }
    public void setSubjectID(String subjectID) { this.SubjectID = subjectID; }

    public String getSubjectName() { return SubjectName; }
    public void setSubjectName(String subjectName) { this.SubjectName = subjectName; }

    public int getSubjectCredit() { return SubjectCredit; }
    public void setSubjectCredit(int subjectCredit) { this.SubjectCredit = subjectCredit; }
}