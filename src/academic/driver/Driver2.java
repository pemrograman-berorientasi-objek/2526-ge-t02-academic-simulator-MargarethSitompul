package academic.driver;

import java.util.Scanner;
import academic.model.Student;

/**
 * @author 12S24006 margareth bungaran 
 * 
 */

public class Driver2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            students[count] = new Student(
                parts[0].trim(),
                parts[1].trim(),
                Integer.parseInt(parts[2].trim()),
                parts[3].trim()
            );

            count++;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }

        scanner.close();
    }
}