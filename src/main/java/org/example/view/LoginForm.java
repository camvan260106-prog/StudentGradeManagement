package org.example.view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JPanel mainPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JRadioButton rbStudent; // Giữ lại
    private JRadioButton rbProfessor; // Giữ lại
    private JRadioButton rbAdmin; // Giữ lại
    private JButton btnLogin;

    public LoginForm() {
        setTitle("Đăng nhập");
        setContentPane(mainPanel);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nhóm các nút Radio
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(rbStudent);
        roleGroup.add(rbProfessor);
        roleGroup.add(rbAdmin);
        rbStudent.setSelected(true);
    }

    // --- Các hàm public để Controller tương tác ---
    public String getUsername() { return txtUsername.getText(); }
    public String getPassword() { return new String(txtPassword.getPassword()); }

    public String getSelectedRole() {
        if (rbStudent.isSelected()) return "Student";
        if (rbProfessor.isSelected()) return "Professor";
        if (rbAdmin.isSelected()) return "Admin";
        return ""; // Không chọn
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Gắn sự kiện nhấn nút "Đăng nhập" cho Controller
    public void addLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }
}