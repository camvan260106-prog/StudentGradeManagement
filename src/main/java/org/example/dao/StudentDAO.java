package org.example.dao;

import org.example.model.Student;
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    /**
     * Lấy thông tin chi tiết của một sinh viên bằng ID (MSSV).
     */
    public Student getStudentById(String studentId) {
        Student student = null;
        // Sử dụng đúng tên cột từ CSDL của bạn
        String sql = "SELECT * FROM Student WHERE studentId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    // 1. Dùng hàm khởi tạo rỗng
                    student = new Student();

                    // 2. Dùng các hàm "set" để gán giá trị (cho tất cả 11 cột)
                    student.setStudentId(rs.getString("studentId"));
                    student.setStudentName(rs.getString("StudentName"));
                    student.setStudentDOB(rs.getDate("StudentDOB"));
                    student.setStudentGender(rs.getString("StudentGender"));
                    student.setStudentMajor(rs.getString("StudentMajor"));
                    student.setStudentEmail(rs.getString("StudentEmail"));
                    student.setStudentPhone(rs.getString("StudentPhone"));
                    student.setStudentHometown(rs.getString("StudentHometown"));
                    student.setParentName(rs.getString("ParentName"));
                    student.setParentPhone(rs.getString("ParentPhone"));
                    student.setStudentStatus(rs.getString("StudentStatus"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Lấy danh sách tất cả sinh viên.
     */
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("studentId"));
                student.setStudentName(rs.getString("StudentName"));
                student.setStudentDOB(rs.getDate("StudentDOB"));
                student.setStudentGender(rs.getString("StudentGender"));
                student.setStudentMajor(rs.getString("StudentMajor"));
                student.setStudentEmail(rs.getString("StudentEmail"));
                student.setStudentPhone(rs.getString("StudentPhone"));
                student.setStudentHometown(rs.getString("StudentHometown"));
                student.setParentName(rs.getString("ParentName"));
                student.setParentPhone(rs.getString("ParentPhone"));
                student.setStudentStatus(rs.getString("StudentStatus"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}