package org.example.model;

public class Professor {

    private String ProfessorID;
    private String ProfessorName;
    private String ProfessorEmail;
    private String ProfessorPhone;
    private String Professorhometown;
    private String ProfessorTitle;

    /**
     * Hàm khởi tạo rỗng (Default Constructor).
     */
    public Professor() { }

    public Professor(String professorID, String professorName, String email,
                     String phone, String title, String hometown) {
        this.ProfessorID = professorID;
        this.ProfessorName = professorName;
        this.ProfessorEmail = email;
        this.ProfessorPhone = phone;
        this.ProfessorTitle = title;
        this.Professorhometown = hometown;
    }

    // 4. CÁC HÀM GETTER (Lấy dữ liệu ra)
    public String getProfessorID() { return ProfessorID; }
    public String getProfessorName() { return ProfessorName; }
    public String getProfessorEmail() { return ProfessorEmail; }
    public String getProfessorPhone() { return ProfessorPhone; }
    public String getProfessorhometown() { return Professorhometown; }
    public String getProfessorTitle() { return ProfessorTitle; }

    /**
     * Các hàm Setters (Gán dữ liệu vào).
     */
    public void setProfessorID(String professorID) { this.ProfessorID = professorID; }
    public void setProfessorName(String professorName) { this.ProfessorName = professorName; }
    public void setProfessorEmail(String professorEmail) { this.ProfessorEmail = professorEmail; }
    public void setProfessorPhone(String professorPhone) { this.ProfessorPhone = professorPhone; }
    public void setProfessorhometown(String professorhometown) { this.Professorhometown = professorhometown; }
    public void setProfessorTitle(String professorTitle) { this.ProfessorTitle = professorTitle; }
}