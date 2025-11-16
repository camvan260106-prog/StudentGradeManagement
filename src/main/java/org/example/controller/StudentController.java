package org.example.controller;

// Import các DAO (Model)
import org.example.dao.CourseDAO;
import org.example.dao.GradeDAO;
import org.example.dao.SemesterDAO;
import org.example.dao.StudentDAO;

// Import các POJO (Model)
import org.example.model.Semester;
import org.example.model.Student;
import org.example.model.StudentCourseView;
import org.example.model.StudentGradeView;

// Import View
import org.example.view.StudentForm;
import org.example.view.StudentDetailForm;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.List;

public class StudentController {

    // --- Khai báo Model (DAO) và View ---
    private final StudentForm view;
    private final StudentDAO studentDAO;
    private final GradeDAO gradeDAO;
    private final SemesterDAO semesterDAO;
    private final CourseDAO courseDAO; // Thêm CourseDAO
    private Student student;
    private final String mssv; // Lưu trữ MSSV của sinh viên này
    private List<StudentGradeView> allGrades; // Cache để tính CPA

    /**
     * Hàm khởi tạo Controller
     * @param view Giao diện (StudentForm) mà nó điều khiển
     * @param mssv Mã số sinh viên (Model)
     */
    public StudentController(StudentForm view, String mssv) {
        this.view = view;
        this.mssv = mssv;

        // Khởi tạo tất cả DAO
        this.studentDAO = new StudentDAO();
        this.gradeDAO = new GradeDAO();
        this.semesterDAO = new SemesterDAO();
        this.courseDAO = new CourseDAO(); // Khởi tạo

        // Liên kết View với Controller này
        this.view.addControllerListener(this);
    }

    /**
     * Hàm này được gọi bởi main() hoặc LoginController
     * để tải toàn bộ dữ liệu lần đầu
     */
    public void loadInitialData() {
        // 1. Tải thông tin SV
        this.student = studentDAO.getStudentById(mssv);
        view.setStudentInfo(this.student);

        // 2. Tải học kỳ vào JComboBox
        List<Semester> semesters = semesterDAO.getAllSemesters();
        view.displaySemesters(semesters);

        // 3. Tải bảng điểm (mặc định là "Kết quả học tập" và "Tất cả học kỳ")
        handleKetQuaRadioSelect();
    }

    // ----- TÍNH TOÁN GPA / CPA -----

    /**
     * Tính toán và hiển thị GPA, CPA
     */
    private void calculateAndDisplayGPA() {
        // 1. Lấy toàn bộ điểm của SV (từ cache nếu có, nếu không thì tải)
        if (this.allGrades == null) {
            this.allGrades = gradeDAO.getGradesForStudentView(mssv);
        }

        // 2. Tính CPA (Điểm trung bình tích lũy) từ toàn bộ điểm
        double cpa = calculateGPA(this.allGrades);
        view.setCPA(formatGPA(cpa));

        // 3. Lấy học kỳ đang chọn từ View
        Semester selectedSemester = view.getSelectedSemester();

        // 4. Tính GPA (Điểm trung bình học kỳ)
        if (selectedSemester != null && !selectedSemester.getSemesterID().equals("ALL")) {
            // Nếu chọn 1 học kỳ cụ thể, tải và lọc danh sách điểm
            List<StudentGradeView> semesterGrades = gradeDAO.getGradesForStudentViewBySemester(mssv, selectedSemester.getSemesterID());
            double gpa = calculateGPA(semesterGrades);
            view.setGPA(formatGPA(gpa));
        } else {
            // Nếu đang chọn "Tất cả học kỳ", thì GPA chính là CPA
            view.setGPA(formatGPA(cpa));
        }
    }

    /**
     * Hàm logic tính GPA (hệ 10) từ một danh sách điểm
     */
    private double calculateGPA(List<StudentGradeView> grades) {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (StudentGradeView g : grades) {
            // Chỉ tính điểm "Đạt" vào GPA/CPA
            if (g.getGradeNote() != null && g.getGradeNote().equalsIgnoreCase("Đạt")) {
                totalPoints += g.getGradeAverage() * g.getSubjectCredit();
                totalCredits += g.getSubjectCredit();
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalPoints / totalCredits; // Đây là GPA hệ 10
    }

    // Hàm làm tròn GPA
    private String formatGPA(double gpa) {
        return new DecimalFormat("0.00").format(gpa);
    }

    // ----- CÁC HÀM XỬ LÝ SỰ KIỆN TỪ VIEW -----

    public void handleDetailButtonClick() {
        // Kiểm tra xem đã tải được thông tin SV chưa
        if (this.student != null) {
            // 1. Tạo View mới
            StudentDetailForm detailView = new StudentDetailForm();

            // 2. Tạo Controller mới (truyền View và Model vào)
            new StudentDetailController(detailView, this.student);

            // 3. Hiển thị View
            detailView.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Chưa thể tải chi tiết (Lỗi dữ liệu sinh viên).");
        }
    }

    public void handleLogoutClick() {
        int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.dispose();
            // new LoginForm()... (Khởi động lại Login theo MVC)
        }
    }

    /**
     * Khi nhấn radio "Kết quả học tập"
     */
    public void handleKetQuaRadioSelect() {
        // Tải lại bảng điểm dựa trên học kỳ đang chọn
        handleSemesterChange();
    }

    /**
     * Khi nhấn radio "Môn học đã đăng ký"
     */
    public void handleMonHocRadioSelect() {
        // Tải bảng danh sách môn học đã đăng ký
        List<StudentCourseView> courses = courseDAO.getStudentCoursesView(mssv);
        view.displayCoursesTable(courses);

        // Khi xem tab này, GPA/CPA không áp dụng
        view.setGPA("N/A");
    }

    /**
     * Khi thay đổi JComboBox Học kỳ (ĐÃ CÓ LOGIC LỌC THẬT)
     */
    public void handleSemesterChange() {
        // Chỉ lọc khi đang ở tab "Kết quả học tập"
        if (!view.isKetQuaSelected()) { // Sửa lỗi gọi rbKetQua
            return;
        }

        Semester selectedSemester = view.getSelectedSemester();

        if (selectedSemester != null) {
            if (selectedSemester.getSemesterID().equals("ALL")) {
                // Tải tất cả điểm
                if (this.allGrades == null) {
                    this.allGrades = gradeDAO.getGradesForStudentView(mssv);
                }
                view.displayGradesTable(this.allGrades);
            } else {
                // Tải điểm theo học kỳ
                List<StudentGradeView> semesterGrades = gradeDAO.getGradesForStudentViewBySemester(mssv, selectedSemester.getSemesterID());
                view.displayGradesTable(semesterGrades);
            }
        }

        // Tính toán lại GPA/CPA
        calculateAndDisplayGPA();
    }
}