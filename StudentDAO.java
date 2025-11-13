package com.codebind.dao;

import com.codebind.model.Student; // Đã sửa: Import Student
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // --- 1. PHƯƠNG THỨC ĐĂNG NHẬP ---
    public Student getStudentByUsername(String username) {
        Student student = null;
        String sql = "SELECT STUDENT_ID, STUDENT_NAME, STUDENT_EMAIL FROM STUDENT WHERE STUDENT_EMAIL = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) return null;

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // SỬ DỤNG CONSTRUCTOR THÔNG TIN CƠ BẢN
                    student = new Student(
                            rs.getString("STUDENT_ID"),
                            rs.getString("STUDENT_NAME"),
                            rs.getString("STUDENT_EMAIL")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn sinh viên theo Username: " + e.getMessage());
        }
        return student;
    }

    // --- 2. PHƯƠNG THỨC TẢI ĐIỂM ---
    public List<Student> loadScoreData(String classId, String semester) { // Đã sửa: List<Student>
        List<Student> studentList = new ArrayList<>();

        String maLop = convertClassNameToId(classId);
        String maKyHoc = convertSemesterToId(semester);

        String sql = "SELECT sv.STUDENT_ID, sv.STUDENT_NAME, d.DiemDG1, d.DiemDG2, d.DiemCKI " +
                "FROM DIEM d JOIN STUDENT sv ON d.STUDENT_ID = sv.STUDENT_ID " +
                "WHERE d.MaLop = ? AND d.MaKyHoc = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) return studentList;

            ps.setString(1, maLop);
            ps.setString(2, maKyHoc);

            try (ResultSet rs = ps.executeQuery()) {
                int stt = 1;
                while (rs.next()) {
                    String maSv = rs.getString("STUDENT_ID");
                    String tenSv = rs.getString("STUDENT_NAME");
                    double dg1 = rs.getDouble("DiemDG1");
                    double dg2 = rs.getDouble("DiemDG2");
                    double cki = rs.getDouble("DiemCKI");

                    double gpa = (dg1 * 0.3 + dg2 * 0.3 + cki * 0.4);
                    gpa = Math.round(gpa * 100.0) / 100.0;

                    // SỬ DỤNG CONSTRUCTOR ĐIỂM SỐ
                    studentList.add(new Student(stt++, maSv, tenSv, dg1, dg2, cki, gpa));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Lỗi truy vấn dữ liệu điểm: " + e.getMessage());
        }
        return studentList;
    }

    // --- 3. PHƯƠNG THỨC LƯU ĐIỂM ---
    public boolean saveScoreData(List<Student> updatedStudents, String classId, String semester) { // Đã sửa: List<Student>
        boolean success = true;

        String maLop = convertClassNameToId(classId);
        String maKyHoc = convertSemesterToId(semester);

        String sql = "UPDATE DIEM SET DiemDG1 = ?, DiemDG2 = ?, DiemCKI = ? " +
                "WHERE STUDENT_ID = ? AND MaLop = ? AND MaKyHoc = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) return false;
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);

            for (Student student : updatedStudents) { // Đã sửa: Student
                ps.setDouble(1, student.getDg1());
                ps.setDouble(2, student.getDg2());
                ps.setDouble(3, student.getCki());
                ps.setString(4, student.getStudentId());
                ps.setString(5, maLop);
                ps.setString(6, maKyHoc);
                ps.addBatch();
            }

            ps.executeBatch();
            conn.commit();

        } catch (SQLException e) {
            success = false;
            System.err.println("❌ Lỗi lưu dữ liệu điểm: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { /* ignored */ }
            }
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) { /* ignored */ }
            DatabaseConnection.closeConnection(conn);
        }
        return success;
    }

    // --- CÁC HÀM CHUYỂN ĐỔI GIẢ ĐỊNH ---
    private String convertClassNameToId(String className) {
        if (className.contains("K20")) return "JAVA20";
        if (className.contains("K19")) return "PTTK19";
        return "UNKNOWN_CLASS";
    }
    private String convertSemesterToId(String semester) {
        if (semester.contains("Kỳ 1")) return "HK1_2526";
        if (semester.contains("Kỳ 2")) return "HK2_2526";
        return "UNKNOWN_SEMESTER";
    }
}