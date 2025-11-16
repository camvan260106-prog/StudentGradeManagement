package org.example.dao;

import org.example.model.Subject;
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    /**
     * Lấy thông tin chi tiết của một môn học bằng ID.
     */
    public Subject getSubjectById(String subjectId) {
        Subject subject = null;
        // Sử dụng đúng tên cột: SubjectID, SubjectName, SubjectCredit
        String sql = "SELECT * FROM Subject WHERE SubjectID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, subjectId);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    // 1. Dùng hàm khởi tạo rỗng
                    subject = new Subject();

                    // 2. Dùng các hàm "set" để gán giá trị
                    subject.setSubjectID(rs.getString("SubjectID"));
                    subject.setSubjectName(rs.getString("SubjectName"));
                    subject.setSubjectCredit(rs.getInt("SubjectCredit"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    /**
     * Lấy danh sách tất cả các môn học.
     */
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM Subject";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getString("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setSubjectCredit(rs.getInt("SubjectCredit"));

                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}