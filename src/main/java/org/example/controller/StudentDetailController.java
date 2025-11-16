// Đặt trong: org/example/controller/StudentDetailController.java
package org.example.controller;

import org.example.model.Student;
import org.example.view.StudentDetailForm;

// Imports cho Apache POI
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDetailController implements ActionListener {

    private final StudentDetailForm view;
    private final Student student; // Model

    public StudentDetailController(StudentDetailForm view, Student student) {
        this.view = view;
        this.student = student;

        // Liên kết Controller này với các nút của View
        this.view.addControllerListener(this);

        // Tải dữ liệu lên View
        loadStudentData();
    }

    /**
     * Lấy dữ liệu từ Model (Student) và hiển thị lên View (JTextArea)
     */
    private void loadStudentData() {
        // Tạo một chuỗi String đẹp từ thông tin sinh viên
        StringBuilder sb = new StringBuilder();
        sb.append("THÔNG TIN CÁ NHÂN\n");
        sb.append("====================\n");
        sb.append("Họ tên: ").append(student.getStudentName()).append("\n");
        sb.append("MSSV: ").append(student.getStudentId()).append("\n");
        sb.append("Ngày sinh: ").append(student.getStudentDOB()).append("\n");
        sb.append("Giới tính: ").append(student.getStudentGender()).append("\n");
        sb.append("Email: ").append(student.getStudentEmail()).append("\n");
        sb.append("Số điện thoại: ").append(student.getStudentPhone()).append("\n");
        sb.append("Quê quán: ").append(student.getStudentHometown()).append("\n");

        sb.append("\nTÌNH TRẠNG HỌC TẬP\n");
        sb.append("====================\n");
        sb.append("Ngành học: ").append(student.getStudentMajor()).append("\n");
        sb.append("Trạng thái: ").append(student.getStudentStatus()).append("\n");

        sb.append("\nTHÔNG TIN GIA ĐÌNH (NGƯỜI LIÊN HỆ)\n");
        sb.append("====================\n");
        sb.append("Họ tên: ").append(student.getParentName()).append("\n");
        sb.append("Số điện thoại: ").append(student.getParentPhone()).append("\n");

        // Ra lệnh cho View hiển thị chuỗi này
        view.setInfoText(sb.toString());
    }

    /**
     * Xử lý sự kiện khi các nút được nhấn
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == view.getBtnQuayLai()) {
            handleQuayLai();
        } else if (source == view.getBtnInHoSo()) {
            handleInHoSo();
        }
    }

    /**
     * Logic cho nút "Quay lại"
     */
    private void handleQuayLai() {
        view.dispose(); // Đóng cửa sổ chi tiết
    }

    /**
     * Logic cho nút "In hồ sơ" (Sử dụng Apache POI)
     */
    private void handleInHoSo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu file Word");
        fileChooser.setSelectedFile(new File("HoSoSinhVien_" + student.getStudentId() + ".docx"));

        int userSelection = fileChooser.showSaveDialog(view);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (XWPFDocument document = new XWPFDocument();
                 FileOutputStream out = new FileOutputStream(fileToSave)) {

                // Lấy tiêu đề (ví dụ: "Hồ sơ sinh viên")
                XWPFParagraph title = document.createParagraph();
                XWPFRun titleRun = title.createRun();
                titleRun.setText("HỒ SƠ SINH VIÊN");
                titleRun.setBold(true);
                titleRun.setFontSize(16);
                titleRun.addBreak(); // Thêm một dòng trống

                // Lấy nội dung từ JTextArea
                String text = view.getInfoText();
                String[] lines = text.split("\\n"); // Tách text thành các dòng

                // Ghi từng dòng vào file Word
                for (String line : lines) {
                    XWPFParagraph paragraph = document.createParagraph();
                    XWPFRun run = paragraph.createRun();
                    run.setText(line);
                }

                document.write(out); // Lưu file

                JOptionPane.showMessageDialog(view, "Đã xuất file Word thành công!");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(view, "Lỗi khi xuất file Word: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}