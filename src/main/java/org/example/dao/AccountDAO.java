package org.example.dao;

import org.example.model.Account;
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    /**
     * Kiểm tra đăng nhập.
     * Trả về đối tượng Account nếu thành công, null nếu thất bại.
     * (LoginController của bạn sẽ gọi hàm này)
     */
    public Account login(String username, String password) {
        Account account = null;
        // Tên cột của bạn là `Password` (P viết hoa)
        String sql = "SELECT * FROM Account WHERE username = ? AND `Password` = ?";

        // Cảnh báo: Mật khẩu nên được mã hóa (hashing) trong thực tế

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 1. Dùng hàm khởi tạo rỗng
                    account = new Account();

                    // 2. Dùng hàm "set"
                    account.setUsername(rs.getString("username"));
                    account.setRole(rs.getString("RoleName"));
                    account.setPassword(rs.getString("Password")); // (Không bắt buộc)
                    account.setCreatedDate(rs.getDate("CreatedDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Trả về "account" (nếu tìm thấy) hoặc "null" (nếu sai)
        return account;
    }
}