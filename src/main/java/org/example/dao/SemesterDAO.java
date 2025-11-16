package org.example.dao;

import org.example.model.Semester;
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SemesterDAO {

    /**
     * Lấy danh sách tất cả các học kỳ,
     * sắp xếp theo ID mới nhất lên trước.
     */
    public List<Semester> getAllSemesters() {
        List<Semester> semesters = new ArrayList<>();
        // Lấy từ bảng 'Semester', sắp xếp theo 'SemesterID'
        String sql = "SELECT * FROM Semester ORDER BY SemesterID DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // 1. Dùng hàm khởi tạo rỗng
                Semester s = new Semester();

                // 2. Dùng các hàm "set" để gán giá trị
                s.setSemesterID(rs.getString("SemesterID"));
                s.setSemesterName(rs.getString("SemesterName"));
                s.setStartDate(rs.getDate("StartDate"));
                s.setEndDate(rs.getDate("EndDate"));

                semesters.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesters;
    }

    /**
     * Lấy thông tin một học kỳ bằng ID.
     */
    public Semester getSemesterById(String semesterId) {
        Semester s = null;
        String sql = "SELECT * FROM Semester WHERE SemesterID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, semesterId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    s = new Semester();
                    s.setSemesterID(rs.getString("SemesterID"));
                    s.setSemesterName(rs.getString("SemesterName"));
                    s.setStartDate(rs.getDate("StartDate"));
                    s.setEndDate(rs.getDate("EndDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}