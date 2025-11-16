package org.example.dao;

import org.example.model.Professor;
import org.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    /**
     * Lấy thông tin chi tiết của một giảng viên bằng ID.
     */
    public Professor getProfessorById(String professorId) {
        Professor prof = null;
        // Sử dụng đúng tên cột từ CSDL của bạn
        String sql = "SELECT * FROM Professor WHERE ProfessorID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, professorId);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    // 1. Dùng hàm khởi tạo rỗng (không tham số)
                    prof = new Professor();

                    // 2. Dùng các hàm "set" để gán giá trị (như bạn yêu cầu)
                    prof.setProfessorID(rs.getString("ProfessorID"));
                    prof.setProfessorName(rs.getString("ProfessorName"));
                    prof.setProfessorEmail(rs.getString("ProfessorEmail"));
                    prof.setProfessorPhone(rs.getString("ProfessorPhone"));
                    prof.setProfessorhometown(rs.getString("Professorhometown"));
                    prof.setProfessorTitle(rs.getString("ProfessorTitle"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    /**
     * Lấy danh sách tất cả giảng viên.
     */
    public List<Professor> getAllProfessors() {
        List<Professor> professors = new ArrayList<>();
        String sql = "SELECT * FROM Professor";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Professor prof = new Professor();
                prof.setProfessorID(rs.getString("ProfessorID"));
                prof.setProfessorName(rs.getString("ProfessorName"));
                prof.setProfessorEmail(rs.getString("ProfessorEmail"));
                prof.setProfessorPhone(rs.getString("ProfessorPhone"));
                prof.setProfessorhometown(rs.getString("Professorhometown"));
                prof.setProfessorTitle(rs.getString("ProfessorTitle"));

                professors.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    // Bạn có thể thêm các phương thức khác như:
    // - addProfessor(Professor prof)
    // - updateProfessor(Professor prof)
    // - deleteProfessor(String professorId)
}