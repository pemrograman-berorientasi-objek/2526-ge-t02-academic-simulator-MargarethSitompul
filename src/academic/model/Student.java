package academic.model;

/**
 * @author 12S24006 margareth bungaran
 * @author 12S24006 margareth bungaran
 */
public class Student {
 private String nim;
    private String name;
    private int year;
    private String program;

    public Student(String nim, String name, int year, String program) {
        this.nim = nim;
        this.name = name;
        this.year = year;
        this.program = program;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + year + "|" + program;
    }
}