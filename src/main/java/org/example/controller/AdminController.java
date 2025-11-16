// Đặt trong: org/example/controller/AdminController.java
package org.example.controller;

import org.example.view.AdminForm;
import org.example.view.LoginForm;
import javax.swing.SwingUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener {

    private final AdminForm view;

    /**
     * Hàm khởi tạo Controller
     */
    public AdminController(AdminForm view) {
        this.view = view;
        // Yêu cầu View báo cho Controller này khi các nút được nhấn
        this.view.addControllerListener(this);
    }

    /**
     * Hàm này tự động chạy khi bất kỳ nút nào trong AdminForm được nhấn
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lấy nguồn của sự kiện (nút nào đã được nhấn)
        Object source = e.getSource();

        // Kiểm tra xem đó là nút nào
        if (source == view.getbtnQuanLySinhVien()) {
            // Logic cho nút "Quản lý Sinh viên"
            JOptionPane.showMessageDialog(view, "Chức năng Quản lý Sinh viên đang phát triển!");
            // (Bạn sẽ mở một cửa sổ quản lý SV mới ở đây)

        } else if (source == view.getbtnQuanLyGiangVien()) {
            // Logic cho nút "Quản lý Giảng viên"
            JOptionPane.showMessageDialog(view, "Chức năng Quản lý Giảng viên đang phát triển!");

        } else if (source == view.getbtnQuanLyMonHoc()) {
            // Logic cho nút "Quản lý Môn học"
            JOptionPane.showMessageDialog(view, "Chức năng Quản lý Môn học đang phát triển!");

        } else if (source == view.getbtnQuanLyLopHocPhan()) {
            // Logic cho nút "Quản lý Lớp học"
            JOptionPane.showMessageDialog(view, "Chức năng Quản lý Lớp học đang phát triển!");

        } else if (source == view.getbtnQuanLyHocKi()) {
            // Logic cho nút "Quản lý Học kỳ"
            JOptionPane.showMessageDialog(view, "Chức năng Quản lý Học kỳ đang phát triển!");

        } else if (source == view.getbtnLogout()) {
            // Logic cho nút "Đăng xuất"
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                view.dispose(); // Đóng cửa sổ Admin
                // (Mở lại cửa sổ Login)
                 SwingUtilities.invokeLater(() -> {
                 LoginForm loginView = new LoginForm();
                 new LoginController(loginView);
                 loginView.setVisible(true);
                 });
            }
        }
    }
}