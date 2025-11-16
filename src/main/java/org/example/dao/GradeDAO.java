// Đặt trong: org/example/dao/GradeDAO.java
package org.example.dao;

import org.example.model.Grade;
import org.example.model.StudentGradeView; // DTO cho JTable
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    /**
     * Lấy thông tin điểm tổng hợp của sinh viên (TẤT CẢ HỌC KỲ).
     * Dùng để tính CPA và hiển thị khi chọn "Tất cả học kỳ".
     * @param studentId Mã sinh viên
     * @return Danh sách các đối tượng StudentGradeView (DTO).
     */
    public List<StudentGradeView> getGradesForStudentView(String studentId) {
        List<StudentGradeView> gradesViewList = new ArrayList<>();

        String sql = "SELECT " +
                "  g.GradeAssessment1, g.GradeAssessment2, g.GradeFinal, g.GradeAverage, g.GradeNote, " +
                "  c.CourseName, " +
                "  s.SubjectID, s.SubjectName, s.SubjectCredit " +
                "FROM Grade g " +
                "JOIN Course c ON g.CourseID = c.CourseId " +
                "JOIN Subject s ON c.SubjectID = s.SubjectID " +
                "WHERE g.StudentID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StudentGradeView gv = new StudentGradeView();
                    gv.setSubjectID(rs.getString("SubjectID"));
                    gv.setSubjectName(rs.getString("SubjectName"));
                    gv.setSubjectCredit(rs.getInt("SubjectCredit"));
                    gv.setCourseName(rs.getString("CourseName"));
                    gv.setGradeAssessment1(rs.getDouble("GradeAssessment1"));
                    gv.setGradeAssessment2(rs.getDouble("GradeAssessment2"));
                    gv.setGradeFinal(rs.getDouble("GradeFinal"));
                    gv.setGradeAverage(rs.getDouble("GradeAverage"));
                    gv.setGradeNote(rs.getString("GradeNote"));
                    gradesViewList.add(gv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesViewList;
    }

    /**
     * Lấy thông tin điểm tổng hợp của sinh viên THEO HỌC KỲ.
     * Dùng để lọc bảng điểm và tính GPA.
     * @param studentId Mã sinh viên
     * @param semesterId Mã học kỳ (vd: 'HK231')
     * @return Danh sách điểm đã lọc.
     */
    public List<StudentGradeView> getGradesForStudentViewBySemester(String studentId, String semesterId) {
        List<StudentGradeView> gradesViewList = new ArrayList<>();

        String sql = "SELECT " +
                "  g.GradeAssessment1, g.GradeAssessment2, g.GradeFinal, g.GradeAverage, g.GradeNote, " +
                "  c.CourseName, c.SemesterID, " +
                "  s.SubjectID, s.SubjectName, s.SubjectCredit " +
                "FROM Grade g " +
                "JOIN Course c ON g.CourseID = c.CourseId " +
                "JOIN Subject s ON c.SubjectID = s.SubjectID " +
                "WHERE g.StudentID = ? AND c.SemesterID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            pstmt.setString(2, semesterId); // Gán tham số học kỳ

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StudentGradeView gv = new StudentGradeView();
                    gv.setSubjectID(rs.getString("SubjectID"));
                    gv.setSubjectName(rs.getString("SubjectName"));
                    gv.setSubjectCredit(rs.getInt("SubjectCredit"));
                    gv.setCourseName(rs.getString("CourseName"));
                    gv.setGradeAssessment1(rs.getDouble("GradeAssessment1"));
                    gv.setGradeAssessment2(rs.getDouble("GradeAssessment2"));
                    gv.setGradeFinal(rs.getDouble("GradeFinal"));
                    gv.setGradeAverage(rs.getDouble("GradeAverage"));
                    gv.setGradeNote(rs.getString("GradeNote"));
                    gradesViewList.add(gv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesViewList;
    }

    // Bạn có thể giữ các phương thức cũ khác (nếu có)
}