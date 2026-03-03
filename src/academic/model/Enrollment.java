package academic.model;

/**
 * @author 12S24006 margareth bungaran 
 * @author 12S24006 margareth bungaran 
 */
public class Enrollment {

    private String courseCode;
    private String studentNim;
    private String academicYear; // Tahun Akademik, misal "2022/2023"
    private String semester; // Semester, misal "Gasal", "Genap"
    private String grade; // Default "None" jika tidak ada nilai spesifik

    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade adalah "None" sesuai spesifikasi output
    }

    // Getter methods (opsional, namun baik untuk praktik OOP)
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }
    
    // Metode setter jika nanti grade bisa diubah
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        // Format output: kode_mk|nim|tahun_akademik|semester|None
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}

