// File: academic/model/Course.java
package academic.model;
   
//@author 12S24006 margareth bungaran
// @author 12S24006 margareth bungaran

public class Course {
   
    private String code;
    private String name;
    private int credit;
    private String grade;

    public Course(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credit + "|" + grade;
    }
}