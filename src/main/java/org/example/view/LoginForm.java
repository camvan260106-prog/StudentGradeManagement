package org.example.view;

/**
 * Import các DAO
import org.example.dao.AccountDAO;
import org.example.dao.ProfessorDAO;
import org.example.dao.StudentDAO;
*/
// Import các Model
import org.example.model.Professor;
import org.example.model.Student;

/* Import các Giao diện (Dashboard)
import org.example.view.AdminDashboard;
import org.example.view.ProfessorDashboard;
import org.example.view.StudentDashboard;
*/
// Import các thư viện Swing và Event
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    // 1. Khai báo các thành phần giao diện (phải khớp fieldName)
    private JPanel mainPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JRadioButton rbStudent;
    private JRadioButton rbProfessor;
    private JRadioButton rbAdmin;
    private JButton btnLogin;

    // 2. Các biến và DAO
    private ButtonGroup roleGroup;
    //private AccountDAO accountDAO;

    public LoginForm() {
        setTitle("Hệ Thống Quản Lý Điểm");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

        // Khởi tạo DAO
        //this.accountDAO = new AccountDAO();

        // Nhóm các nút Radio
        roleGroup = new ButtonGroup();
        roleGroup.add(rbStudent);
        roleGroup.add(rbProfessor);
        roleGroup.add(rbAdmin);
        rbStudent.setSelected(true); // Đặt "Sinh viên" làm mặc định

        // Gán sự kiện cho nút Đăng nhập
       /** btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin(); // Gọi hàm xử lý
            }
        }); */
    }
    /**
     * Xử lý logic khi nhấn nút Đăng nhập
     */
    /**
    private void handleLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String roleNameInDB = ""; // Tên vai trò lưu trong CSDL

        // Ánh xạ từ Giao diện sang tên vai trò trong CSDL
        if (rbStudent.isSelected()) {
            roleNameInDB = "Student";
        } else if (rbProfessor.isSelected()) {
            roleNameInDB = "Professor";
        } else if (rbAdmin.isSelected()) {
            roleNameInDB = "Admin";
        }

        // 1. Gọi DAO để kiểm tra với CSDL
        if (accountDAO.checkLogin(username, password, roleNameInDB)) {
            // ĐĂNG NHẬP THÀNH CÔNG

            // 2. Đóng cửa sổ Đăng nhập (LoginForm) hiện tại
            this.dispose();

            // 3. Mở cửa sổ (Dashboard) mới dựa trên vai trò
            if (roleNameInDB.equals("Admin")) {
                AdminDashboard adminForm = new AdminDashboard();
                adminForm.setVisible(true);

            } else if (roleNameInDB.equals("Professor")) { // <-- ĐÃ SỬA LỖI TYPO
                // LẤY THÔNG TIN GIẢNG VIÊN
                ProfessorDAO profDAO = new ProfessorDAO();
                Professor professor = profDAO.getProfessorById(username); // username chính là ProfessorID

                if (professor != null) {
                    // Chuyền đối tượng Professor sang Dashboard mới
                    ProfessorDashboard profForm = new ProfessorDashboard(professor);
                    profForm.setVisible(true);
                } else {
                    // Lỗi: Đăng nhập được nhưng không tìm thấy thông tin GV
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công nhưng không thể tải dữ liệu Giảng viên!");
                    new LoginForm().setVisible(true); // Mở lại Login
                }

            } else if (roleNameInDB.equals("Student")) {
                // LẤY THÔNG TIN SINH VIÊN
                StudentDAO studentDAO = new StudentDAO();
                Student student = studentDAO.getStudentById(username); // username chính là StudentID

                if (student != null) {
                    // Chuyền đối tượng Student sang Dashboard mới
                    StudentDashboard studentForm = new StudentDashboard(student);
                    studentForm.setVisible(true);
                } else {
                    // Lỗi: Đăng nhập được nhưng không tìm thấy thông tin SV
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công nhưng không thể tải dữ liệu Sinh viên!");
                    new LoginForm().setVisible(true); // Mở lại Login
                }
            }

        } else {
            // ĐĂNG NHẬP THẤT BẠI
            JOptionPane.showMessageDialog(this,
                    "Tên đăng nhập, mật khẩu hoặc vai trò không đúng!",
                    "Lỗi Đăng nhập",
                    JOptionPane.ERROR_MESSAGE);
        }
    }*/
        }