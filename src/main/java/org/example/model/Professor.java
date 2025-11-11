package org.example.model;

public class Professor {
    private String professorID;
    private String professorName;
    private String email;
    private String phone;
    private String title;
    private String hometown;

    // Constructor
    public Professor(String professorID, String professorName, String email, String phone, String title, String hometown) {
        this.professorID = professorID;
        this.professorName = professorName;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.hometown = hometown;
    }

    // Getters
    public String getProfessorID() { return professorID; }
    public String getProfessorName() { return professorName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getTitle() { return title; }
    public String getHometown() { return hometown; }
}