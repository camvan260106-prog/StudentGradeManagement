package org.example.model;

import java.util.Date;

public class Account {

    // Khai báo biến
    private String username;
    private String Password; // 'P' viết hoa khớp CSDL
    private String RoleName;
    private Date CreatedDate;

    /**
     * Hàm khởi tạo rỗng (BẮT BUỘC CÓ)
     */
    public Account() { }

    // ----- Getters and Setters -----

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return Password; }
    public void setPassword(String password) { this.Password = password; }

    public String getRole() { return RoleName; } // Dùng getRole() cho dễ hiểu
    public void setRole(String roleName) { this.RoleName = roleName; }

    public Date getCreatedDate() { return CreatedDate; }
    public void setCreatedDate(Date createdDate) { this.CreatedDate = createdDate; }
}