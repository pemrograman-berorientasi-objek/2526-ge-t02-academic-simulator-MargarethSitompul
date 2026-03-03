package academic.model;

/**
 * @author 12S24006 margareth bungaran 
 * @author 12S24006 margareth bungaran 
 */
public class Enrollment {

    private String courseCode;
    private String studentNim;
    private String academicYear;
    private String semester;
    private String grade;

    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}