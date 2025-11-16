// Đặt trong: org/example/view/AdminForm.java
package org.example.view;

import javax.swing.*;
import java.awt.event.ActionListener; // Import ActionListener

public class AdminForm extends JFrame { // Kế thừa JFrame
    private JPanel mainPanel;
    private JButton btnQuanLySinhVien;
    private JButton btnQuanLyGiangVien;
    private JButton btnQuanLyMonHoc;
    private JButton btnQuanLyLopHocPhan;
    private JButton btnQuanLyHocKi;
    private JButton btnLogout;


    /**
     * Hàm khởi tạo của View Admin
     */
    public AdminForm() {
        setTitle("Trang Quản trị (Admin)");
        setContentPane(mainPanel); // "panel1" là field name của panel chính
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Gắn sự kiện cho các nút
     * (Controller sẽ gọi hàm này)
     */
    public void addControllerListener(ActionListener controller) {
        btnQuanLySinhVien.addActionListener(controller);
        btnQuanLyGiangVien.addActionListener(controller);
        btnQuanLyMonHoc.addActionListener(controller);
        btnQuanLyLopHocPhan.addActionListener(controller);
        btnQuanLyHocKi.addActionListener(controller);
        btnLogout.addActionListener(controller);
    }

    // ----- Các hàm public để Controller lấy tên nút -----
    // (Giúp Controller biết nút nào vừa được nhấn)
    public JButton getbtnQuanLySinhVien() {
        return btnQuanLySinhVien;
    }

    public JButton getbtnQuanLyGiangVien() {
        return btnQuanLyGiangVien;
    }

    public JButton getbtnQuanLyMonHoc() {
        return btnQuanLyMonHoc;
    }

    public JButton getbtnQuanLyLopHocPhan() {
        return btnQuanLyLopHocPhan;
    }

    public JButton getbtnQuanLyHocKi() {
        return btnQuanLyHocKi;
    }

    public JButton getbtnLogout() {
        return btnLogout;
    }

    public JButton getBtnQuanLyLopHocPhan() {
        return btnQuanLyLopHocPhan;
    }

    public void setBtnQuanLyLopHocPhan(JButton btnQuanLyLopHocPhan) {
        this.btnQuanLyLopHocPhan = btnQuanLyLopHocPhan;
    }

    public JButton getBtnQuanLyMonHoc() {
        return btnQuanLyMonHoc;
    }

    public void setBtnQuanLyMonHoc(JButton btnQuanLyMonHoc) {
        this.btnQuanLyMonHoc = btnQuanLyMonHoc;
    }

    public JButton getBtnQuanLyGiangVien() {
        return btnQuanLyGiangVien;
    }

    public void setBtnQuanLyGiangVien(JButton btnQuanLyGiangVien) {
        this.btnQuanLyGiangVien = btnQuanLyGiangVien;
    }

    public JButton getBtnQuanLySinhVien() {
        return btnQuanLySinhVien;
    }

    public void setBtnQuanLySinhVien(JButton btnQuanLySinhVien) {
        this.btnQuanLySinhVien = btnQuanLySinhVien;
    }
}