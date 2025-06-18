import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        // Variables to compute statistics
        double total = 0;
        double highest = -1;
        double lowest = 101;
        String highestStudent = "", lowestStudent = "";

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                highestStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        // Display report
        System.out.println("\n=== Summary Report ===");
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.printf("Highest Grade: %.2f (by %s)\n", highest, highestStudent);
        System.out.printf("Lowest Grade: %.2f (by %s)\n", lowest, lowestStudent);

        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            System.out.println(s.name + " - Grade: " + s.grade);
        }

        scanner.close();
    }
}
