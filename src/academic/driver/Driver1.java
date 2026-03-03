package academic.driver;

import java.util.Scanner;
import academic.model.Course;

/**
 * @author 12S24006 margareth bungaran 
 * 
 */

public class Driver1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100];
        int count = 0;

        while (scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();

            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            courses[count++] = new Course(
                parts[0].trim(),
                parts[1].trim(),
                Integer.parseInt(parts[2].trim()),
                parts[3].trim()
            );
        }

        for (int i = 0; i < count; i++) {
            System.out.println(courses[i].toString());
        }

        scanner.close();
    }
}