package org.example.controller;

import org.example.dao.AccountDAO;
import org.example.model.Account;
import org.example.view.LoginForm;
import org.example.view.StudentForm;
import org.example.controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private final LoginForm view;
    private final AccountDAO accountDAO;

    public LoginController(LoginForm view) {
        this.view = view;
        this.accountDAO = new AccountDAO(); // Model
        this.view.addLoginListener(this); // Gắn Controller vào nút của View
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Lấy thông tin từ View
        String username = view.getUsername();
        String password = view.getPassword();
        String roleNameFromView = view.getSelectedRole();

        // 2. Gọi Model (DAO) để kiểm tra CSDL
        // (Tôi giả sử hàm login trả về Account)
        Account account = accountDAO.login(username, password);

        // 3. Xử lý kết quả
        if (account != null && account.getRole().equals(roleNameFromView)) {
            // ĐĂNG NHẬP THÀNH CÔNG VÀ ĐÚNG VAI TRÒ

            view.dispose(); // Đóng Login

            // Mở cửa sổ mới dựa trên vai trò
            if (roleNameFromView.equals("Student")) {
                openStudentView(username); // username là MSSV

            } else if (roleNameFromView.equals("Professor")) {
                // openProfessorView(username); // username là ProfessorID
                view.showMessage("Đăng nhập Giảng viên thành công! (Chưa có giao diện)");
            } else if (roleNameFromView.equals("Admin")) {
                // openAdminView();
                view.showMessage("Đăng nhập Admin thành công! (Chưa có giao diện)");
            }
        } else {
            // ĐĂNG NHẬP THẤT BẠI
            view.showMessage("Tên đăng nhập, mật khẩu hoặc vai trò không đúng.");
        }
    }

    /**
     * Hàm riêng để mở StudentForm theo đúng mô hình MVC
     */
    private void openStudentView(String mssv) {
        StudentForm studentView = new StudentForm();
        StudentController studentController = new StudentController(studentView, mssv);
        studentController.loadInitialData();
        studentView.setVisible(true);
    }
}