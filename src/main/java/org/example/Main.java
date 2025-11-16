package org.example; // Hoặc package gốc
import org.example.controller.LoginController;
import org.example.view.LoginForm;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm loginView = new LoginForm();
            new LoginController(loginView); // Controller tự gắn vào View
            loginView.setVisible(true);
        });
    }
}