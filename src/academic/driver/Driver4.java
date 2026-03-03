package academic.driver;

import java.util.Scanner;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;

/**
 * @author 12S24006 margareth bungaran
 * 
mport academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
 */
public class Driver4 {

     // Konstanta untuk ukuran maksimum array statis
    private static final int MAX_ENTITIES = 100;

    // Array statis terpisah untuk setiap entitas
    private static Course[] courses = new Course[MAX_ENTITIES];
    private static int courseCount = 0;

    private static Student[] students = new Student[MAX_ENTITIES];
    private static int studentCount = 0;

    private static Enrollment[] enrollments = new Enrollment[MAX_ENTITIES];
    private static int enrollmentCount = 0;

    public static void main(String[] _args) {

        Scanner inputScanner = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data (course-add#... / student-add#... / enrollment-add#...). Ketik '---' untuk berhenti.");

        while (inputScanner.hasNextLine()) {
            line = inputScanner.nextLine();

            if (line.equals("---")) {
                break; // Keluar dari loop jika input adalah "---"
            }

            if (line.trim().isEmpty()) {
                System.err.println("[WARNING] Baris input kosong diabaikan.");
                continue;
            }

            // Memisahkan perintah dari data
            String[] parts = line.split("#", 2); // Split hanya pada # pertama
            if (parts.length < 2) {
                System.err.println("[WARNING] Format perintah tidak valid: '" + line + "'.");
                continue;
            }

            String command = parts[0].trim();
            String dataString = parts[1].trim();
            String[] dataSegments = dataString.split("#"); // Pisahkan data di bagian kedua

            switch (command) {
                case "course-add":
                    processCourseAdd(dataSegments, line);
                    break;
                case "student-add":
                    processStudentAdd(dataSegments, line);
                    break;
                case "enrollment-add":
                    processEnrollmentAdd(dataSegments, line);
                    break;
                default:
                    System.err.println("[WARNING] Perintah tidak dikenal: '" + command + "' pada baris: '" + line + "'.");
                    break;
            }
        }

        inputScanner.close();

        // Menampilkan seluruh data sesuai urutan
        displayAllData();
    }

    private static void processCourseAdd(String[] dataSegments, String originalLine) {
        // Validasi jumlah segmen untuk Course (kode, nama, sks, grade -> 4 segmen)
        if (dataSegments.length != 4) {
            System.err.println("[WARNING] Format input COURSE tidak valid (butuh 4 segmen): '" + originalLine + "'.");
            return;
        }

        String code = dataSegments[0].trim();
        String name = dataSegments[1].trim();
        int sks;
        String grade = dataSegments[3].trim(); // Grade untuk Course ini bisa menjadi grade default atau kosong

        try {
            sks = Integer.parseInt(dataSegments[2].trim());
        } catch (NumberFormatException e) {
            System.err.println("[WARNING] SKS harus berupa angka bulat untuk course pada baris: '" + originalLine + "'.");
            return;
        }

        if (courseCount >= MAX_ENTITIES) {
            System.err.println("[WARNING] Kapasitas penyimpanan Course penuh. Data tidak ditambahkan: '" + originalLine + "'.");
            return;
        }

        courses[courseCount] = new Course(code, name, sks, grade);
        courseCount++;
    }

    private static void processStudentAdd(String[] dataSegments, String originalLine) {
        // Validasi jumlah segmen untuk Student (nim, nama, angkatan, prodi -> 4 segmen)
        if (dataSegments.length != 4) {
            System.err.println("[WARNING] Format input STUDENT tidak valid (butuh 4 segmen): '" + originalLine + "'.");
            return;
        }

        String nim = dataSegments[0].trim();
        String name = dataSegments[1].trim();
        int year;
        String studyProgram = dataSegments[3].trim();

        try {
            year = Integer.parseInt(dataSegments[2].trim());
        } catch (NumberFormatException e) {
            System.err.println("[WARNING] Angkatan harus berupa angka bulat untuk student pada baris: '" + originalLine + "'.");
            return;
        }

        if (studentCount >= MAX_ENTITIES) {
            System.err.println("[WARNING] Kapasitas penyimpanan Student penuh. Data tidak ditambahkan: '" + originalLine + "'.");
            return;
        }

        students[studentCount] = new Student(nim, name, year, studyProgram);
        studentCount++;
    }

    private static void processEnrollmentAdd(String[] dataSegments, String originalLine) {
        // Validasi jumlah segmen untuk Enrollment (kode_mk, nim, tahun_akademik, semester -> 4 segmen)
        if (dataSegments.length != 4) {
            System.err.println("[WARNING] Format input ENROLLMENT tidak valid (butuh 4 segmen): '" + originalLine + "'.");
            return;
        }

        String courseCode = dataSegments[0].trim();
        String studentNim = dataSegments[1].trim();
        String academicYear = dataSegments[2].trim();
        String semester = dataSegments[3].trim();
        
        if (enrollmentCount >= MAX_ENTITIES) {
            System.err.println("[WARNING] Kapasitas penyimpanan Enrollment penuh. Data tidak ditambahkan: '" + originalLine + "'.");
            return;
        }

        // Grade untuk Enrollment secara default adalah "None"
        enrollments[enrollmentCount] = new Enrollment(courseCode, studentNim, academicYear, semester);
        enrollmentCount++;
    }

    private static void displayAllData() {
        System.out.println("\n--- Data Courses Tersimpan ---");
        if (courseCount == 0) {
            System.out.println("Tidak ada data Course.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println(courses[i]);
            }
        }

        System.out.println("\n--- Data Students Tersimpan ---");
        if (studentCount == 0) {
            System.out.println("Tidak ada data Student.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
            }
        }

        System.out.println("\n--- Data Enrollments Tersimpan ---");
        if (enrollmentCount == 0) {
            System.out.println("Tidak ada data Enrollment.");
        } else {
            for (int i = 0; i < enrollmentCount; i++) {
                // Enrollment toString() sudah mencakup "|None"
                System.out.println(enrollments[i]);
            }
        }
    }
}

    