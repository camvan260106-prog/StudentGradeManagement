package org.example.utils; // Đảm bảo đúng tên package

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // --- !!! THAY ĐỔI CÁC THÔNG SỐ NÀY !!! ---

    // Tên database bạn đã tạo trong MySQL
    private static final String DB_NAME = "db_quanlydiem";

    // Tên đăng nhập MySQL
    private static final String USERNAME = "root";

    // Mật khẩu của MySQL của bạn
    private static final String PASSWORD = "Luctam@1504"; //

    // --- (Các thông số khác thường giữ nguyên) ---
    private static final String HOST = "localhost"; // 127.0.0.1
    private static final int PORT = 3306; // Cổng mặc định của MySQL
    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

    /**
     * Phương thức tĩnh (static) để lấy kết nối đến CSDL.
     * Các lớp DAO sẽ gọi hàm này.
     * @return một đối tượng Connection, hoặc null nếu kết nối thất bại.
     */
    public static Connection getConnection() {
        try {
            // Lấy kết nối
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            return conn;
        } catch (SQLException e) {
            System.err.println("LỖI: Không thể kết nối đến CSDL.");
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi
        }
    }

    /** Hàm main để KIỂM TRA KẾT NỐI NHANH.*/

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Chúc mừng! Kết nối CSDL thành công!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Kết nối CSDL thất bại. Vui lòng kiểm tra lại thông số.");
        }
    }
}