// Đặt trong: org/example/dao/CourseDAO.java
package org.example.dao;

import org.example.model.Course;
import org.example.model.StudentCourseView; // Import DTO
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    /**
     * Lấy thông tin các môn học sinh viên đã đăng ký (JOIN 4 bảng).
     * Dùng cho tab "Môn học đã đăng ký".
     * @param studentId Mã sinh viên
     * @return Danh sách DTO StudentCourseView.
     */
    public List<StudentCourseView> getStudentCoursesView(String studentId) {
        List<StudentCourseView> coursesList = new ArrayList<>();

        String sql = "SELECT " +
                "  c.CourseName, c.SemesterID, " +
                "  s.SubjectID, s.SubjectName, s.SubjectCredit, " +
                "  p.ProfessorName " +
                "FROM Grade g " +
                "JOIN Course c ON g.CourseID = c.CourseId " +
                "JOIN Subject s ON c.SubjectID = s.SubjectID " +
                "JOIN Professor p ON c.ProfessorID = p.ProfessorID " +
                "WHERE g.StudentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StudentCourseView scv = new StudentCourseView();
                    scv.setCourseName(rs.getString("CourseName"));
                    scv.setSemesterID(rs.getString("SemesterID"));
                    scv.setSubjectID(rs.getString("SubjectID"));
                    scv.setSubjectName(rs.getString("SubjectName"));
                    scv.setSubjectCredit(rs.getInt("SubjectCredit"));
                    scv.setProfessorName(rs.getString("ProfessorName"));
                    coursesList.add(scv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursesList;
    }

    // Bạn có thể giữ các phương thức cũ khác (như getCourseById)
}