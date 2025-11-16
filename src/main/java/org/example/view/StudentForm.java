package org.example.view;

import org.example.controller.StudentController;
import org.example.model.Semester;
import org.example.model.Student;
import org.example.model.StudentCourseView; // Import DTO mới
import org.example.model.StudentGradeView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentForm extends JFrame {

    // Khai báo đầy đủ các biến từ file .form
    private JPanel mainPanel;
    private JPanel profilePanel;
    private JButton btnLogout;
    private JButton btnChiTiet;
    private JLabel lblHoTen;
    private JLabel lblMSSV;
    private JLabel lblEmail;
    private JLabel lblSdt;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JComboBox<Semester> comboKyHoc; // Đổi thành JComboBox<Semester>
    private JPanel navigationPanel;
    private JLabel lblGPA;
    private JLabel lblCPA;
    private JPanel selectionPanel;
    private JRadioButton rbKetQua;
    private JRadioButton rbMonHoc;
    private JTable tblKetQua;

    public StudentForm() {
        setTitle("Trang thông tin sinh viên");
        setContentPane(mainPanel);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(rbKetQua);
        radioGroup.add(rbMonHoc);
        rbKetQua.setSelected(true);

        // Cài đặt JComboBox để hiển thị SemesterName
        comboKyHoc.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Semester) {
                    setText(((Semester) value).getSemesterName());
                }
                return this;
            }
        });
    }

    // ----- CÁC HÀM PUBLIC ĐỂ CONTROLLER GỌI -----

    public void setStudentInfo(Student student) {
        if (student != null) {
            lblHoTen.setText(student.getStudentName());
            lblMSSV.setText(student.getStudentId());
            lblEmail.setText(student.getStudentEmail());
            lblSdt.setText(student.getStudentPhone());
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy thông tin sinh viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displaySemesters(List<Semester> semesters) {
        comboKyHoc.removeAllItems();
        // Thêm một mục "Tất cả học kỳ" để xem CPA
        Semester all = new Semester();
        all.setSemesterID("ALL");
        all.setSemesterName("Tất cả học kỳ");
        comboKyHoc.addItem(all);

        for (Semester s : semesters) {
            comboKyHoc.addItem(s);
        }
    }

    /**
     * Hiển thị bảng điểm (Kết quả học tập)
     */
    public void displayGradesTable(List<StudentGradeView> grades) {
        String[] columnNames = {
                "STT", "MÃ MÔN", "TÊN MÔN", "LỚP HỌC PHẦN", "SỐ TÍN",
                "ĐIỂM QT", "ĐIỂM THI", "ĐIỂM TB", "XẾP LOẠI"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        int stt = 1;
        for (StudentGradeView gv : grades) {
            Object[] row = new Object[9]; // Sửa thành 9 cột
            row[0] = stt++;
            row[1] = gv.getSubjectID();
            row[2] = gv.getSubjectName();
            row[3] = gv.getCourseName();
            row[4] = gv.getSubjectCredit();
            row[5] = gv.getGradeAssessment1() + " | " + gv.getGradeAssessment2();
            row[6] = gv.getGradeFinal();
            row[7] = gv.getGradeAverage();
            row[8] = gv.getGradeNote();
            model.addRow(row);
        }
        tblKetQua.setModel(model);
    }

    /**
     * (HÀM MỚI) Hiển thị bảng Môn học đã đăng ký
     */
    public void displayCoursesTable(List<StudentCourseView> courses) {
        String[] columnNames = {
                "STT", "HỌC KỲ", "MÃ MÔN", "TÊN MÔN", "LỚP HỌC PHẦN", "SỐ TÍN", "GIẢNG VIÊN"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        int stt = 1;
        for (StudentCourseView scv : courses) {
            Object[] row = new Object[7]; // 7 cột
            row[0] = stt++;
            row[1] = scv.getSemesterID();
            row[2] = scv.getSubjectID();
            row[3] = scv.getSubjectName();
            row[4] = scv.getCourseName();
            row[5] = scv.getSubjectCredit();
            row[6] = scv.getProfessorName();
            model.addRow(row);
        }
        tblKetQua.setModel(model); // Vẫn dùng chung 1 JTable
    }

    // (HÀM MỚI) Cập nhật GPA và CPA
    public void setGPA(String gpa) {
        lblGPA.setText("GPA: " + gpa);
    }
    public void setCPA(String cpa) {
        lblCPA.setText("CPA: " + cpa);
    }

    // (HÀM MỚI) Lấy học kỳ đang chọn
    public Semester getSelectedSemester() {
        return (Semester) comboKyHoc.getSelectedItem();
    }

    // Liên kết View với Controller
    public void addControllerListener(StudentController controller) {
        btnChiTiet.addActionListener(e -> controller.handleDetailButtonClick());
        btnLogout.addActionListener(e -> controller.handleLogoutClick());
        rbKetQua.addActionListener(e -> controller.handleKetQuaRadioSelect());
        rbMonHoc.addActionListener(e -> controller.handleMonHocRadioSelect());
        comboKyHoc.addActionListener(e -> controller.handleSemesterChange());
    }
    /**
     * Báo cho Controller biết radio "Kết quả học tập" có đang được chọn không.
     * @return true nếu được chọn, false nếu không.
     */
    public boolean isKetQuaSelected() {
        return rbKetQua.isSelected();
    }

    // ----- HÀM MAIN ĐỂ CHẠY CHƯƠNG TRÌNH -----
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String mssv = "SV001"; // Chạy thử với SV001

            StudentForm view = new StudentForm();
            StudentController controller = new StudentController(view, mssv);
            controller.loadInitialData();
            view.setVisible(true);
        });
    }
}