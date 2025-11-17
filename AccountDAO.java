package com.codebind.dao;

import com.codebind.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public Account findAccountByUsernameAndPassword(String username, String password, String role) {
        String sql = "SELECT USERNAME, ROLE, EMAIL FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ? AND ROLE = ?";
        Connection conn = null;
        Account account = null;

        try {
            conn = DatabaseConnection.getConnection();
            if (conn != null) {
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, role);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            String foundUsername = rs.getString("USERNAME");
                            String foundRole = rs.getString("ROLE");
                            String foundEmail = rs.getString("EMAIL");

                            account = new Account(foundUsername, "", foundRole, foundEmail);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn CSDL: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return account;
    }
}