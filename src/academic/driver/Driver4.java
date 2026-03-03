package academic.driver;

import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @author 12S24006 margareth bungaran 
 * 
 */  

public class Driver4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int courseCount = 0;
        int studentCount = 0;
        int enrollmentCount = 0;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            String command = parts[0].trim();

            if (command.equals("course-add")) {

                courses[courseCount] = new Course(
                    parts[1].trim(),
                    parts[2].trim(),
                    Integer.parseInt(parts[3].trim()),
                    parts[4].trim()
                );
                courseCount++;

            } else if (command.equals("student-add")) {

                students[studentCount] = new Student(
                    parts[1].trim(),
                    parts[2].trim(),
                    Integer.parseInt(parts[3].trim()),
                    parts[4].trim()
                );
                studentCount++;

            } else if (command.equals("enrollment-add")) {

                enrollments[enrollmentCount] = new Enrollment(
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim(),
                    parts[4].trim()
                );
                enrollmentCount++;
            }
        }

        // PRINT URUTAN WAJIB
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }

        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }

        scanner.close();
    }
}