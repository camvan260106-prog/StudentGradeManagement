// Đặt trong: org/example/view/StudentDetailForm.java
package org.example.view;

import javax.swing.*;
import java.awt.event.ActionListener; // Import

public class StudentDetailForm extends JFrame { // Kế thừa JFrame
    private JPanel mainPanel;
    private JButton btnInHoSo;
    private JButton btnQuayLai;
    private JTextArea txtInfo;

    // (Các component khác từ file .form của bạn)

    /**
     * Hàm khởi tạo View
     */
    public StudentDetailForm() {
        setTitle("Chi tiết Hồ sơ Sinh viên");
        setContentPane(mainPanel);
        setSize(800, 600); // Đặt kích thước
        setLocationRelativeTo(null); // Mở ở giữa

        // DISPOSE_ON_CLOSE: Chỉ đóng cửa sổ này, không tắt toàn bộ ứng dụng
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // ----- CÁC HÀM PUBLIC ĐỂ CONTROLLER GỌI -----

    /**
     * Hiển thị văn bản thông tin lên JTextArea
     */
    public void setInfoText(String text) {
        txtInfo.setText(text);
    }

    /**
     * Lấy văn bản từ JTextArea (để xuất file Word)
     */
    public String getInfoText() {
        return txtInfo.getText();
    }

    /**
     * Gắn sự kiện (listener) cho các nút
     */
    public void addControllerListener(ActionListener controller) {
        btnInHoSo.addActionListener(controller);
        btnQuayLai.addActionListener(controller);
    }

    // ----- Getters cho các nút (để Controller nhận diện) -----
    public JButton getBtnInHoSo() { return btnInHoSo; }
    public JButton getBtnQuayLai() { return btnQuayLai; }
}