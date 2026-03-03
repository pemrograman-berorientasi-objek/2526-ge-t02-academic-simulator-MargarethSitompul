// File: academic/model/Course.java
package academic.model;
   
//@author 12S24006 margareth bungaran
// @author 12S24006 margareth bungaran

public class Course {
    private String code;
    private String name;
    private int sks;
    private String grade;

    public Course(String code, String name, int sks, String grade) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.grade = grade;
    }

    // Getter methods (jika diperlukan untuk diakses di luar kelas,
    // namun untuk kebutuhan saat ini, toString sudah cukup)
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSks() {
        return sks;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + sks + "|" + grade;
    }
}
