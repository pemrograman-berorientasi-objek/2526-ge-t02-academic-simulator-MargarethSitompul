package academic.driver;

import java.util.Scanner;
import academic.model.Enrollment;

/**
 * @author 12S24006 margareth bungaran 
 * 
 */ 

public class Driver3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Enrollment[] enrollments = new Enrollment[100];
        int count = 0;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            enrollments[count] = new Enrollment(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim()
            );

            count++;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(enrollments[i].toString());
        }

        scanner.close();
    }
}