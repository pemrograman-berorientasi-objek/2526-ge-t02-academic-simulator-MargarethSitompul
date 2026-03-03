package academic.model;

/**
 * @author 12S24006 margareth bungaran
 * @author 12S24006 margareth bungaran
 */
public class Student {
 private String nim;
    private String name;
    private int year; // Angkatan
    private String studyProgram; // Program Studi

    public Student(String nim, String name, int year, String studyProgram) {
        this.nim = nim;
        this.name = name;
        this.year = year;
        this.studyProgram = studyProgram;
    }

    // Getter methods (opsional, namun baik untuk praktik OOP)
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    @Override
    public String toString() {
        // Format output: nim|nama|angkatan|program_studi
        return nim + "|" + name + "|" + year + "|" + studyProgram;
    }
}

    
